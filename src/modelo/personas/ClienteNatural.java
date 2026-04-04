package modelo.personas;
import java.time.LocalDate;
import modelo.abstractas.Persona;

public class ClienteNatural extends Persona{
    
    private String tipoDocumento;
    private String numeroDocumento;
    private Object[ ] cuentas = new Object[5]; //CAMBIAR POR CUENTA DESPUES DE TERMINARLA 100%
    private int cont = 0;
    
    
    
    public ClienteNatural (String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                          String tipoDocumento, String numeroDocumento) {

        super(id, nombre, apellido, fechaNacimiento, email);
        
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        
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
    
}
