package principal;
import java.time.LocalDate;
import java.time.Month;
import modelo.personas.ClienteNatural;
import modelo.personas.ClienteEmpresarial;
import modelo.cuentas.CuentaAhorro;

public class SistemaBancarioDemo {
    
    public static void main(String[] args) {
       
        ClienteNatural cliente = new ClienteNatural("1222", "Eliana", "Vertel", LocalDate.of(2003, 8, 13), "eli@gmail.com", "cc", "8766");
        ClienteEmpresarial cliente2 = new ClienteEmpresarial("1222", "Eliana", "Vertel", LocalDate.of(2020, 4, 20), "contabilidad@mje.com",
                                                                                            "98885278 - ", "MJE SAS", "Air Vertel");
        
        CuentaAhorro cuenta = new CuentaAhorro("000098787", 988782, 0.7, 5);
        
        
        cliente.agregarCuenta("Ahorros 000098787");
        cliente.agregarCuenta("credito 0999");
        
        Object[] listaCuentas = cliente.getCuentas();
        for (int i = 0; i < listaCuentas.length; i++) {
            if (listaCuentas[i] != null){
                System.out.println(listaCuentas[i]);
            }
            
        }
         
        System.out.println("\n--------------------CLIENTE---------------------------");
        System.out.println("Nombre: " + cliente.getNombreCompleto());
        System.out.println("Edad: " + cliente.calcularEdad());
        System.out.println("Tipo de Cliente: " + cliente.obtenerTipo());
        System.out.println("Documento: " + cliente.obtenerDocumentoIdentidad());
        System.out.println("\nNIT: " + cliente2.obtenerDocumentoIdentidad());
        System.out.println("Tipo de Cliente: " + cliente2.obtenerTipo());
        
        
        System.out.println("\n-------------------CUENTA ----------------------------");
        System.out.println("Saldo: " + cuenta.getSaldo());
        System.out.println("Interés mensual: " + cuenta.calcularInteres());
        System.out.println("Tipo Cuenta: " + cuenta.getTipoCuenta());
        
        
        
        
    }
    
}
