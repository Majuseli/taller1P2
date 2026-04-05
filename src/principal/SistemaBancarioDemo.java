package principal;
import java.time.LocalDate;
import java.time.Month;
import modelo.personas.ClienteNatural;

public class SistemaBancarioDemo {
    
    public static void main(String[] args) {
       
        ClienteNatural cliente = new ClienteNatural("1222", "Eliana", "Vertel", LocalDate.of(2003, 8, 13), "eli@gmail.com", "cc", "8766");
        
        
        cliente.agregarCuenta("Ahorros 12233");
        cliente.agregarCuenta("credito 0999");
        
        Object[] listaCuentas = cliente.getCuentas();
        for (int i = 0; i < listaCuentas.length; i++) {
            if (listaCuentas[i] != null){
                System.out.println(listaCuentas[i]);
            }
            
        }
         
        
        System.out.println("Nombre: " + cliente.getNombreCompleto());
        System.out.println("Edad: " + cliente.calcularEdad());
        System.out.println("Tipo de Cliente: " + cliente.obtenerTipo());
        System.out.println("Documento: " + cliente.obtenerDocumentoIdentidad());
        
        
        
        
    }
    
}
