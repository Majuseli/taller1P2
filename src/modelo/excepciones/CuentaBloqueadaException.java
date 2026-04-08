
package modelo.excepciones;

public class CuentaBloqueadaException extends SistemaBancarioException{
    
    public CuentaBloqueadaException (String mensaje, String codigoError) {
        super(mensaje, codigoError);
        
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "Cuenta bloqueada";
    }
    
}
