package modelo.banco;

import java.time.LocalDateTime;
import modelo.abstractas.Cuenta;
import modelo.enums.EstadoTransaccion;
import modelo.excepciones.EstadoTransaccionInvalidoException;

public class Transaccion {
    
    private String id;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double monto;
    private EstadoTransaccion estado;
    private LocalDateTime fecha;
    private String descripcion;
    
    
    
    public Transaccion(String id, Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto, String descripcion) {
        this.id = id;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fecha = LocalDateTime.now();
    }
    
    
    

    public void cambiarEstado(EstadoTransaccion nuevoEstado) throws EstadoTransaccionInvalidoException {
        
        if (nuevoEstado == null) {
            throw new EstadoTransaccionInvalidoException("Estado Inválido. No puede ser NULL");
        }

        boolean valido = false; 

        switch (estado) {

            case PENDIENTE:
                if (nuevoEstado == EstadoTransaccion.PROCESANDO || nuevoEstado == EstadoTransaccion.RECHAZADA) {
                    valido = true;
                }
                break;

            case PROCESANDO:
                if (nuevoEstado == EstadoTransaccion.COMPLETADA || nuevoEstado == EstadoTransaccion.RECHAZADA) {
                    valido = true;
                }
                break;

            case COMPLETADA:
                if (nuevoEstado == EstadoTransaccion.REVERTIDA) {
                    valido = true;
                }
                break;

            default:
                valido = false;
        }
        

        //VALIDACION DE TRANSACCION
        if (!valido) { 
            throw new EstadoTransaccionInvalidoException( "Transición inválida de " + estado + " a " + nuevoEstado);
        }
        this.estado = nuevoEstado;
        
    }
    
   
    public String generarComprobante() {

        return "ID: " + id
                + "\nMonto: " + monto
                + "\nEstado: " + estado
                + "\nFecha: " + fecha
                + "\nDescripción: " + descripcion;
    }


}
