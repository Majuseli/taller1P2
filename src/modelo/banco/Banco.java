
package modelo.banco;
import modelo.abstractas.*;
import modelo.excepciones.CapacidadExcedidaException;
import modelo.excepciones.ClienteNoEncontradoException;

public class Banco {
    
    private String nombre;
    private Empleado[] empleados = new Empleado[50];
    private int contadorEmpleados = 0;
    private Cliente[] clientes = new Cliente[200];
    private int contadorClientes = 0;
    private Cuenta[] cuentas = new Cuenta[500];
    private int contadorCuentas = 0;
    
    
    
    public void registrarCliente(Cliente c) throws CapacidadExcedidaException {
        
        if (contadorClientes >= clientes.length) {
            throw new CapacidadExcedidaException("Capacidad Máxima de Clientes Alcanzada", "ERROR_CLIENTES", clientes.length);
        }
        
        clientes[contadorClientes] = c; //Agregando en arrays
        contadorClientes++;
        
    }
    
    
    
    public void registrarEmpleado (Empleado e) throws CapacidadExcedidaException {
        
        if (contadorEmpleados >= empleados.length){
            throw new CapacidadExcedidaException("Capacidad Máxima de Empleados Alcanzada", "ERROR_EMPLEADOS", empleados.length);
        }
        
        
        empleados[contadorEmpleados] = e;
        contadorEmpleados++;
    }
    
    
    
    public Cliente buscarCliente (String id) throws ClienteNoEncontradoException { 
        
        for (int i = 0; i < contadorClientes; i++){ 
            
            if (clientes[i].getId().equals(id)){
                return clientes[i]; 
            }

        }  throw new ClienteNoEncontradoException("Cliente No Encontrado", "ERROR_CLIENTE", id);
        
    }
    
    
    
    public void abrirCuenta (String idCliente, Cuenta c) throws ClienteNoEncontradoException, CapacidadExcedidaException{
        
        Cliente cliente = buscarCliente(idCliente);

        if (contadorCuentas >= cuentas.length) { //Validar capacidad del banco 
            throw new CapacidadExcedidaException("Capacidad Máxima de Cuentas Alcanzada", "ERROR_CUENTAS", cuentas.length);
        }
        
        
        cuentas[contadorCuentas] = c;
        contadorCuentas++;
        
        //AQUI agregar cuenta al cliente despues de modificar cliente natural
  
    }
    
    
}
