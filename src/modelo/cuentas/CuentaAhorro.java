package modelo.cuentas;

import modelo.abstractas.Cuenta;

public class CuentaAhorro extends Cuenta {
    
    private double tasaInteres;
    private int retirosMesActual;
    private int maxRetirosMes;
    
    
  
    public CuentaAhorro(String numeroCuenta, double saldo, double tasaInteres, int maxRetirosMes) {

        super(numeroCuenta, saldo);

        this.tasaInteres = tasaInteres;
        this.maxRetirosMes = maxRetirosMes;
        this.retirosMesActual = 0;
    }
    
    
    @Override
    public double calcularInteres() {
        return getSaldo() * tasaInteres / 12;
    }

    @Override
    public double getLimiteRetiro() {
        return 1000; 
    }

    @Override
    public String getTipoCuenta() {
        return "AHORROS";
    }
    
    
    @Override
    public double calcularComision(double monto) {
        return monto * 0.004;
    }
    
    
    //CONSULTABLE
    @Override
    public String obtenerTipo() {
        return "Cuenta de Ahorros";
    }


    @Override
    public String obtenerResumen() {
        return "Numero: " + getNumeroCuenta() + " | Saldo: " + getSaldo();
    }
    
    
    @Override
    public boolean estaActivo() {
        return consultarSaldo() >= 0;
}
    
}
