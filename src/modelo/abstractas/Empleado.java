package modelo.abstractas;

import java.time.LocalDate;
import modelo.excepciones.DatoInvalidoException;



public abstract class Empleado extends Persona {
    
    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;
    
    
    
    public Empleado (String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, 
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        
        super(id, nombre, apellido, fechaNacimiento, email);
        
        this.legajo = legajo;
        setFechaContratacion(fechaContratacion);
        setSalarioBase(salarioBase);
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
    public void setFechaContratacion(LocalDate fechaContratacion) throws DatoInvalidoException{
        if (fechaContratacion  == null || fechaContratacion.isAfter(LocalDate.now())) {
            throw new DatoInvalidoException("Fecha Inválida", "Fecha Contratación", fechaContratacion);
        }
        this.fechaContratacion = fechaContratacion;
    }

    public void setSalarioBase(double salarioBase) throws DatoInvalidoException{
        if (salarioBase <= 0) {
            throw new DatoInvalidoException("Salario Inválido", "SalarioBase", salarioBase);
        }
        this.salarioBase = salarioBase;
    }
    
    
    //METODO CONCRETO HEREDABLE
    public int calcularAntiguedad() {
    return LocalDate.now().getYear() - fechaContratacion.getYear();

}
   
    
    //METODOS ABSTRACTOS
    public abstract double calcularSalario();
    
    public abstract double calcularBono();
    
    
    
    //METODOS HEREDADOS DE PERSONA
    @Override
    public int calcularEdad() {
        return java.time.Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
    }

    @Override
    public String obtenerTipo() {
        return "Empleado";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return getLegajo();
    }
    

      
}
