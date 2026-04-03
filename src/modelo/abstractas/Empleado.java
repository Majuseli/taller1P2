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
        
        this.legajo = legajo;
        this.activo = activo;
        
    }
    
    
    
    //GETTERS  
    public String getLegajo() {
        return legajo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
    //SETTERS CON VALIDACION
    public void setFechaContratacion(LocalDate fechaContratacion) {
        if (fechaContratacion  == null || fechaContratacion.isAfter(LocalDate.now())) {
            System.out.println("FECHA INVALIDA");  //AQUI EXCEPTION RuntimeException
        }
        this.fechaContratacion = fechaContratacion;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            System.out.println("SALARIO INVALIDO"); // AQUI EXCEPTION RuntimeException
        }
        this.salarioBase = salarioBase;
    }
    
    
    
    
   
    
}
