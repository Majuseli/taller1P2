package modelo.abstractas;

import java.time.LocalDate;


public abstract class Empleado extends Persona {
    
    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;
    
    
    
    public Empleado (String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, 
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        
        super(id, nombre, apellido, fechaNacimiento, email);
    
    
    }
    
}
