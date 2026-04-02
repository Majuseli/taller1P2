package modelo.abstractas;

import java.time.LocalDate;


public abstract class Persona {
    
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private  String email;

    //CONTROLADOR CON SETTER PARA VALIDAR DESDE EL INICIO
    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setFechaNacimiento(fechaNacimiento);
        setEmail(email);
        
    }
    
    
    
    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    //SETTERS CON LA VALIDACIÓN
    public void setId(String id) {
        if(id == null || id.isEmpty()) {
            System.out.println("ID Invalido"); //AQUI DatoInvalidoException
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre Invalido"); //AQUI DatoInvalidoException
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            System.out.println("Apelliod Invalido"); //AQUI DatoInvalidoException
        }
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            System.out.println("Fecha Invalida"); //AQUI DatoInvalidoException
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Email Invalido"); //AQUI DatoInvalidoException
        }
        this.email = email;
    }
    
    
    
    //METODO CONCRETO HEREDABLE
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
    
    
    
    //METODOS ABSTRACTOS PARA LAS SUBCLASES
    public abstract int calcularEdad();

    public abstract String obtenerTipo();

    public abstract String obtenerDocumentoIdentidad();
   
    
     
}
