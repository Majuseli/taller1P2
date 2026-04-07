
package modelo.excepciones;

public class SaldoInsuficienteException extends SistemaBancarioException{
    
    private double saldoActual;
    private double montoSolicitado;
    
    
    public SaldoInsuficienteException(String mensaje, String codigoError, double saldoActual, double montoSolicitado) {
        super(mensaje, codigoError);
        this.saldoActual = saldoActual;
        this.montoSolicitado = montoSolicitado;
    }
    
    
    public double getSaldoActual() {
        return saldoActual;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Saldo actual: " + saldoActual + "   |   Monto solicitado: " + montoSolicitado;
    }
    
}
