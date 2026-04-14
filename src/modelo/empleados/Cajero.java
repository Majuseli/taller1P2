package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;
import modelo.abstractas.Cuenta;
import modelo.enums.Turno;
import modelo.excepciones.PermisoInsuficienteException;

public class Cajero extends Empleado {
    
    private Turno turno;
    private String sucursalAsignada;
    private int transaccionesDia;

    public Cajero(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo,
                            Turno turno, String sucursalAsignada) {
        
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.turno = turno;
        this.sucursalAsignada = sucursalAsignada;
        this.transaccionesDia = 0;
    }
    
    

    //METODOS HEREDADOS DE LA CLASE EMPLEADO
    @Override
    public double calcularBono() {
        return  transaccionesDia * 2000; 
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }
    
    
    
    public void aprobarCredito(Cuenta cuenta) {
        throw new PermisoInsuficienteException("Accion denegada: El Cajero no tiene habilitada esta opción.");
    }
    
    public void registrarTransaccion() {
        this.transaccionesDia++;
    }
}
