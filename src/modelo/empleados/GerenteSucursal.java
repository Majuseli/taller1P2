package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;
import modelo.abstractas.Cuenta;

public class GerenteSucursal extends Empleado{
    
    private String sucursal;
    private double presupuestoAnual;
    private Empleado[] empleadosACargo;
    private int contadorEmpleados;
    
    public GerenteSucursal(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                           String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, 
                           String sucursal, double presupuestoAnual) {
        
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.sucursal = sucursal;
        this.presupuestoAnual = presupuestoAnual;
        this.empleadosACargo = new Empleado[30];
        this.contadorEmpleados = 0;
    }
    
    
    //METODOS HEREDADOS DE LA CLASE EMPLEADO
    @Override
    public double calcularBono() {
        double bonoAntiguedad = calcularAntiguedad() * 100000; 
        double bonoFijoGerencia = 500000;
        return bonoAntiguedad + bonoFijoGerencia;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }
    
    
    
    public void aprobarCredito(Cuenta cuenta) {
        System.out.println("Gerente " + getNombreCompleto() + " aprobo el credito para la cuenta: " + cuenta.getNumeroCuenta());
    }
    
    

    public Empleado[] getEmpleadosACargo() {
        Empleado[] copia = new Empleado[contadorEmpleados];
        System.arraycopy(empleadosACargo, 0, copia, 0, contadorEmpleados);
        return copia;
    }
    
}
