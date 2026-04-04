package principal;
import java.time.LocalDate;
import java.time.Month;
import modelo.personas.ClienteNatural;

public class SistemaBancarioDemo {
    
    public static void main(String[] args) {
       
        ClienteNatural cliente = new ClienteNatural("98876", "Eliana", "Vertel", LocalDate.of(2003, 8, 13), "Eli@gmail.com", "cc", "56555");
        
        System.out.println("Nombre: " + cliente.getNombreCompleto());
        System.out.println("Edad: " + cliente.calcularEdad());
        System.out.println("Tipo de Cliente: " + cliente.obtenerTipo());
        System.out.println("Documento: " + cliente.obtenerDocumentoIdentidad());
        
        
        
    }
    
}
