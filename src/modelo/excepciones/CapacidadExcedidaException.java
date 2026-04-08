
package modelo.excepciones;


public class CapacidadExcedidaException extends SistemaBancarioException {
    
    private int capacidadMaxima;
    
    public CapacidadExcedidaException (String mensaje, String codigoError, int capacidadMaxima) {
        super(mensaje, codigoError);
        this.capacidadMaxima = capacidadMaxima;
    
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "Capacidad máxima: " + capacidadMaxima;
    }
    
}
