package modelo.personas;
import java.time.LocalDate;
import modelo.abstractas.Persona;
import modelo.interfaces.*;
import java.time.LocalDateTime;
import modelo.abstractas.Cuenta;
import modelo.excepciones.CapacidadExcedidaException;


public class ClienteNatural extends Persona implements Consultable, Notificable, Auditable{
    
    private String tipoDocumento;
    private String numeroDocumento;
    private Cuenta[ ] cuentas = new Cuenta[5]; 
    private int cont = 0;
    
    //INTERFACES AUDITABLE Y NOTIFICABLE
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;
    private boolean aceptaNotificaciones;
    
    
    
    public ClienteNatural (String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                          String tipoDocumento, String numeroDocumento) {

        super(id, nombre, apellido, fechaNacimiento, email);
        
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaCreacion = LocalDateTime.now();
        this.aceptaNotificaciones = true;
        
    }
    
    
    
    //AGREGAR CUENTA
    public void agregarCuenta(Cuenta cuenta) throws CapacidadExcedidaException{
        
        if (cont >= cuentas.length) {
            throw new CapacidadExcedidaException("Máximo de Cuentas Alcanzado", "ERROR_CUENTAS_CLIENTE", cuentas.length);
            
        }
        cuentas[cont++] = cuenta;
        
    }
    
    
    public Cuenta[] getCuentas() {
        Cuenta[] copia = new Cuenta[cont];
    
        System.arraycopy(cuentas, 0, copia, 0, cont);
        
        return copia;
    }
    
    
    
    //METODOS ABSTRACTOS DE LA CLASE PADRE
    @Override
    public int calcularEdad() {
        return java.time.Period.between(getFechaNacimiento(), LocalDate.now() ).getYears();
    }

    @Override
    public String obtenerTipo() {
        return "Natural";
    }

    @Override
    public String obtenerDocumentoIdentidad(){
        return tipoDocumento + " " + numeroDocumento;
    }
    
    
    
   //METODOS CONSULTABLE
    @Override
    public String obtenerResumen() {
    return getNombreCompleto() + " - " + obtenerDocumentoIdentidad();
    }

    @Override
    public boolean estaActivo() {
    return true;
    }
    
    //METODOS NOTIFICABLE
    @Override
    public void notificar(String mensaje) {
        if (aceptaNotificaciones) {
            System.out.println("Notificación: " + mensaje);
        }
    }

    @Override
    public String obtenerContacto() {
        return getEmail();
    }

    @Override
    public boolean aceptaNotificaciones() {
        return aceptaNotificaciones;
    }
    
    
    //METODOS AUDITABLE
    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return usuarioModificacion;
    }

    @Override
    public void registrarModificacion(String usuario) {
        this.usuarioModificacion = usuario;
        this.ultimaModificacion = LocalDateTime.now();
    }
    
}
