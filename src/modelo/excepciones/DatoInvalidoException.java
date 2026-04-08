
package modelo.excepciones;


public class DatoInvalidoException extends BancoRuntimeException {
    private String campo;
    private Object valorRecibido;
    
    
    public DatoInvalidoException(String mensaje, String campo, Object valorRecibido) {
        super(mensaje);
        this.campo = campo;
        this.valorRecibido = valorRecibido;
    }

    public String getCampo() {
        return campo;
    }

    public Object getValorRecibido() {
        return valorRecibido;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "Campo: " + campo + "   |    Valor recibido: " + valorRecibido;
    }
    
}
