package modelo.cuentas;

import modelo.abstractas.Cuenta;


public class CuentaCorriente extends Cuenta {
    
    private double montoSobregiro;
    private double comisionMantenimiento;
    
    
    public CuentaCorriente(String numeroCuenta, double saldo, double montoSobregiro, double comisionMantenimiento) {

        super(numeroCuenta, saldo);

        this.montoSobregiro = montoSobregiro;
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    
    
    
    @Override
    public double calcularInteres() {
        return 0; 
    }

    @Override
    public double getLimiteRetiro() {
        return getSaldo() + montoSobregiro;
    }

    @Override
    public String getTipoCuenta() {
        return "CORRIENTE";
    }
    
    
    @Override
    public double calcularComision(double monto) {
        return monto * 0.01;
    }
    
}
