package modelo.cuentas;

import modelo.abstractas.Cuenta;

public class CuentaCredito extends Cuenta{
    
    private double limiteCredito;
    private double tasaInteres;
    private double deudaActual;
    
    
    
     public CuentaCredito(String numeroCuenta, double saldo, double limiteCredito, double tasaInteres) {

        super(numeroCuenta, saldo);

        this.limiteCredito = limiteCredito;
        this.tasaInteres = tasaInteres;
        this.deudaActual = 0;
     }
     
     
     
     
     @Override
    public double calcularInteres() {
        return deudaActual * tasaInteres / 12;
    }

    @Override
    public double getLimiteRetiro() {
        return limiteCredito - deudaActual;
    }

    @Override
    public String getTipoCuenta() {
        return "CREDITO";
    }
    
    
    @Override
    public double calcularComision(double monto) {
        return monto * 0.02;
}
    
    
    //CONSULTABLE
    @Override
    public String obtenerTipo() {
        return "Cuenta de Credito";
    }

    @Override
    public String obtenerResumen() {
        return "Numero: " + getNumeroCuenta()+ " | Cupo: " + consultarSaldo();
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }
    
}
