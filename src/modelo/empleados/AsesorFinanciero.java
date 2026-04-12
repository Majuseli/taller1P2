package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class AsesorFinanciero  extends Empleado{
    
    public AsesorFinanciero(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
    }
    
    
//METODOS HEREDADOS DE LA CLASE EMPLEADO
    @Override
    public double calcularBono() {
        return getSalarioBase() * 0.10;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }
    
}
