package modelo.abstractas;

import java.time.LocalDateTime;

public abstract class Cuenta {
    
    private String numeroCuenta;
    private double saldo;
    private boolean bloqueada;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;
    private Object[] historial = new Object[20]; //CAMBIAR POR TRANSACCION DESPUES DE CREARLA
    private int cont = 0;
    
    
    
    
    
    
    
    //METODOS ABSTRACTOS
    public abstract double calcularInteres();
    
    public abstract double getLimiteRetiro();
    
    public abstract String getTipoCuenta();
    
}
