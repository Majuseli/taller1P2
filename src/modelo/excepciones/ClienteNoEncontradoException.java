
package modelo.excepciones;

public class ClienteNoEncontradoException extends SistemaBancarioException {
    
    private  String idCliente;
    
    
    public ClienteNoEncontradoException (String mensaje, String codigoError, String idCliente){
        super(mensaje, codigoError);
        this.idCliente = idCliente;
        
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    
    @Override
    public String toString (){
        return super.toString() + "ID cliente: " + idCliente;
    
    }
    
}
