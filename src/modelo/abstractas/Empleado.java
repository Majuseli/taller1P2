package modelo.abstractas;

import java.time.LocalDate;


public abstract class Empleado extends Persona {
    
    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;
    
}
