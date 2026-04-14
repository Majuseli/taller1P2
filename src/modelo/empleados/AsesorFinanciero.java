package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;
import modelo.abstractas.Cliente;

public class AsesorFinanciero  extends Empleado{
    
    private double comisionBase;
    private double metasMensuales;
    private Cliente[] clientesAsignados;
    private int contadorClientes;
    
    
    public AsesorFinanciero(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                                            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo,
                                            double comisionBase, double metasMensuales) {
        
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.comisionBase = comisionBase;
        this.metasMensuales = metasMensuales;
        this.clientesAsignados = new Cliente[20];
        this.contadorClientes = 0;
    }
    
    
//METODOS HEREDADOS DE LA CLASE EMPLEADO
    @Override
    public double calcularBono() {
        return  (comisionBase > metasMensuales) ? comisionBase * 1.15 : comisionBase;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }
    
    
    
    public Cliente[] getClientesAsignados() {
        Cliente[] copia = new Cliente[contadorClientes];
        System.arraycopy(clientesAsignados, 0, copia, 0, contadorClientes);
        return copia;
    }
    
    
}
