package modelo.abstractas;
import  modelo.interfaces.Transaccionable;
import modelo.excepciones.*;
import modelo.banco.Transaccion;
import java.time.LocalDateTime;
import modelo.excepciones.CuentaBloqueadaException;

public abstract class Cuenta implements Transaccionable{
    
    private String numeroCuenta;
    private double saldo;
    private boolean bloqueada;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;
    private Transaccion[ ] historial = new Transaccion[20]; 
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
    
    
    public void agregarAlHistorial(Transaccion t) throws  CapacidadExcedidaException{  
        if (cont >= historial.length) {
            throw new CapacidadExcedidaException("Historial Lleno", "ERROR_HISTORIAL", historial.length);
        }
        historial[cont++] = t;
    }

    public Transaccion[] getHistorial() {
        Transaccion[] copia = new Transaccion[cont];
        System.arraycopy(historial, 0, copia, 0, cont);
        return copia;
    }
    
  
    //METODOS ABSTRACTOS
    public abstract double calcularInteres();
    
    public abstract double getLimiteRetiro();
    
    public abstract String getTipoCuenta();
    
    @Override
    public abstract double calcularComision(double monto);

    
    
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

        if (monto > getLimiteRetiro()) {
            throw new SaldoInsuficienteException("Saldo Insuficiente", "ERROR_SALDO", saldo, monto);

        }

        this.saldo -= monto;
    }

   

    @Override
    public double consultarSaldo() {
        return saldo;
    }
    
}
