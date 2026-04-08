
package modelo.excepciones;

public class BancoRuntimeException extends RuntimeException {
    
    public BancoRuntimeException (String mensaje) {
        super(mensaje);
    }
    
    
    @Override
    public String toString(){
        return "Error de ejecución: " + getMessage();
    }
    
}
