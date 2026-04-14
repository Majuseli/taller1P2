
package modelo.abstractas;
import  java.time.LocalDate;
import modelo.excepciones.CapacidadExcedidaException;
import modelo.abstractas.Cuenta;


public abstract class Cliente extends Persona{
    
    public Cliente (String id, String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        super(id, nombre, apellido, fechaNacimiento, email);
    }
    
    
    public abstract void agregarCuenta(Cuenta c) throws CapacidadExcedidaException;
}
