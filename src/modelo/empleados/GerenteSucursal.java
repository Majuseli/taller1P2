package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class GerenteSucursal extends Empleado{
    
    public GerenteSucursal(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                           String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
    }
    
    
    //METODOS HEREDADOS DE LA CLASE EMPLEADO
    @Override
    public double calcularBono() {
        return getSalarioBase() * 0.17;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }
    
}
