package modelo.personas;

import java.time.LocalDate;
import modelo.abstractas.Persona;

 
public class ClienteEmpresarial extends Persona{
    private String nit;
    private String razonSocial;
    private String representanteLegal;
    private Object[] cuentas = new Object[5]; //CAMBIAR POR CUENTA DESPUES DE TERMINARLA 100%
    private int cont = 0;
    
    
    
    //CONTADOR
    public ClienteEmpresarial(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                              String nit, String razonSocial, String representanteLegal) {

        super(id, nombre, apellido, fechaNacimiento, email);

        this.nit = nit;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;
        
    }
    
    
    //AGREGAR CUENTA
    public void agregarCuenta(Object cuenta) {
        if (cont >= cuentas.length) {
            
            System.out.println("Máximo de cuentas alcanzado"); // AQUI EXCEPTION CapacidadExcedidaException
        }
        cuentas[cont++] = cuenta;
        
    }
    
    
    public Object[] getCuentas() {
        return cuentas.clone();
    }
    
    
    
    //METODOS ABSTRACTOS
    @Override
    public int calcularEdad() {
        return java.time.Period.between(getFechaNacimiento(), LocalDate.now() ).getYears();
    }

    @Override
    public String obtenerTipo() {
        return "Empresarial";
    }

    @Override
    public String obtenerDocumentoIdentidad(){
        return   nit;
    }
        
    
    
}
