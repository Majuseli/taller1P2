package modelo.abstractas;
import  modelo.interfaces.Transaccionable;
import modelo.excepciones.*;

import java.time.LocalDateTime;
import modelo.excepciones.CuentaBloqueadaException;

public abstract class Cuenta implements Transaccionable{
    
    private String numeroCuenta;
    private double saldo;
    private boolean bloqueada;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;
    private Object[ ] historial = new Object[20]; //CAMBIAR POR TRANSACCION DESPUES DE CREARLA
    private int cont = 0;
    
    
    //CONSTRUCTOR
    public Cuenta (String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.bloqueada = false;
        this.fechaCreacion = LocalDateTime.now();
    
    }
    

    //GETTERS
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    
    
    //METODOS CONCRETOS
    public void verificarBloqueada() throws CuentaBloqueadaException {
        if (bloqueada) {
            throw new CuentaBloqueadaException("Cuenta Bloqueada", "ERROR_BLOQUEADA");
        }
    }
    
    
    public void agregarAlHistorial(Object i) {  //CAMBIAR POR TRANSACCION DESPUES DE CREARLA
        if (cont >= historial.length) {
            System.out.println("Historial lleno"); //AQUI EXCEPTION CuentaBloqueadaException
        }
        historial[cont++] = i;
    }

    public Object[ ] getHistorial() {
        return historial.clone(); //DEVUELVE UNA COPIA
    }
    
  
    //METODOS ABSTRACTOS
    public abstract double calcularInteres();
    
    public abstract double getLimiteRetiro();
    
    public abstract String getTipoCuenta();
    
    
    
  //METODOS TRANSACCIONABLE
    @Override
    public void depositar(double monto) throws CuentaBloqueadaException {
        verificarBloqueada();

        if (monto <= 0) {
            throw new DatoInvalidoException("Monto Inválido", "Monto", monto);

        }
        this.saldo += monto;
    }

    @Override
    public void retirar(double monto) throws CuentaBloqueadaException, SaldoInsuficienteException {

        verificarBloqueada();

        if (monto <= 0) {
            throw new DatoInvalidoException("Monto Inválido", "Monto", monto);
            
        }

        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo Insuficiente", "ERROR_SALDO", saldo, monto);

        }

        this.saldo -= monto;
    }

   
    @Override
    public double calcularComision(double monto) {
        return monto * 0.01; //CAMBIAR DESPUES
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
    
}
