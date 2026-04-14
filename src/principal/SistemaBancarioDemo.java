package principal;
import java.time.LocalDate;
import modelo.banco.Banco;
import modelo.personas.ClienteNatural;
import modelo.personas.ClienteEmpresarial;
import modelo.cuentas.CuentaAhorro;
import modelo.empleados.AsesorFinanciero;
import modelo.empleados.Cajero;
import modelo.empleados.GerenteSucursal;
import modelo.abstractas.Cliente;
import modelo.abstractas.Cuenta;
import modelo.abstractas.Empleado;
import modelo.banco.Transaccion;
import modelo.cuentas.CuentaCorriente;
import modelo.cuentas.CuentaCredito;
import modelo.enums.EstadoTransaccion;
import modelo.enums.TipoCuenta;
import modelo.enums.Turno;
import modelo.excepciones.CuentaBloqueadaException;
import modelo.excepciones.EstadoTransaccionInvalidoException;
import modelo.excepciones.PermisoInsuficienteException;
import modelo.excepciones.SaldoInsuficienteException;


public class SistemaBancarioDemo {
    
    public static void main(String[] args) {
        
        try {
            Banco banco = new Banco(); //Creaccion de banco
            
            
            //CREACION DE EMPLEADOS
            GerenteSucursal gerente = new GerenteSucursal("1111", "Martha", "Diaz", LocalDate.of(1970, 2, 21), "marha1@gmail.com", 
                                                                                            "G1111", LocalDate.of(2017, 6, 1), 6929000, true, "Sucursal1", 780600000);
            
            
            AsesorFinanciero asesor = new AsesorFinanciero("2222", "Jose", "Perez", LocalDate.of(1989, 11, 2), "joperez2@gmail.com", 
                                                               "A2222", LocalDate.of(2020, 1, 15), 2900000, true, 300000, 100000000);
            
            
            Cajero cajero = new Cajero("3333", "Maria", "Gonzalez", LocalDate.of(1993, 3, 12), "gzz333@gmail.com", 
                                                        "C3333", LocalDate.of(2024, 6, 15), 1750000, true, Turno.MAÑANA, "Sucursal1");
            
            banco.registrarEmpleado(gerente);
            banco.registrarEmpleado(asesor);
            banco.registrarEmpleado(cajero);
            
            
            
            //CREACION DE CLIENTES
            Cliente cliente1 = new ClienteNatural("0001", "Pablo", "Torres", LocalDate.of(1990, 7, 1), "pablo01@gmail.com", "CC", "1068234879");
            
            Cliente cliente2 = new ClienteEmpresarial("0002", "Business", "SAS", LocalDate.of(2003, 1, 1), "business@gmail.com", "900123", "MyBusiness", "Carlos Sanchez");
            
            Cliente cliente3 = new ClienteNatural("0003", "Eliana", "Vertel", LocalDate.of(2003, 8, 13), "evc@gmail.com", "CC", "1068136346");
                    
            banco.registrarCliente(cliente1);
            banco.registrarCliente(cliente2);
            banco.registrarCliente(cliente3);
            
            
            
            //CREACION DE CUENTAS
            Cuenta cuenta1 = new CuentaAhorro("22193111", 1245000, 0.05, 5000000);
            
            Cuenta cuenta2 = new CuentaCorriente("1234567", 348500000, 0.20, 0);
            
            Cuenta cuenta3 = new CuentaCredito("000333", 1300000, 2000000, 0.5);
            
            banco.abrirCuenta("0001", cuenta1);
            banco.abrirCuenta("0002", cuenta2);
            banco.abrirCuenta("0003", cuenta3);
            
            
            
            //3. DEPOSITO EXITOSO Y CUENTA BLOQUEADA
            System.out.println("========DEPOSITO========");
            try {
                cuenta1.depositar(200000);
                System.out.println("Deposito Exitoso");
                
                cuenta1.setBloqueada(true);
                cuenta1.depositar(50000);
            } catch (CuentaBloqueadaException e) {
                System.out.println("!ERROR¡: " + e.getMessage());
            }
            
            
            
            
            //4. RETIRO EXITOSO Y SALDO INSUFICIENTE
            System.out.println("\n========RETIRO========");
            try {
                cuenta2.retirar(100000000);
                System.out.println("Retiro Exitoso");
                
                cuenta2.retirar(400000000);
            } catch (SaldoInsuficienteException e) {
                System.out.println("¡ERROR!: " + e.getMessage());
            } 
            
            
            
            
            //5. TRANSFERENCIA ENTRE DOS CUENTAS    -    8. ESTADO DE TRANSACCION INVALIDO
            System.out.println("\n========TRANSFERENCIA========");
            cuenta1.setBloqueada(false);
            try {
                double montoTransferencia = 400000;

                Transaccion transferencia = new Transaccion("TR-001", cuenta3, cuenta1, montoTransferencia, "Transferencia entre cuentas");

                cuenta3.retirar(montoTransferencia);
                cuenta1.depositar(montoTransferencia);

                transferencia.cambiarEstado(EstadoTransaccion.REVERTIDA);
                transferencia.cambiarEstado(EstadoTransaccion.COMPLETADA);

                System.out.println(transferencia.generarComprobante());

            } catch (CuentaBloqueadaException | SaldoInsuficienteException e) {
                System.out.println("¡ERROR! en la operacion bancaria: " + e.getMessage());
            } catch (EstadoTransaccionInvalidoException e) {
                System.out.println("¡ERROR!: " + e.getMessage());
            }

         
            
            //6. RECORRER EMPLEADO Y CALCULAR SALARIO
            System.out.println("\n========SALARIO EMPLEADOS========");
            Empleado[] empleados = {gerente, asesor, cajero};
            for (Empleado e : empleados) {
                System.out.println(e.obtenerTipo() + ": " + e.getNombreCompleto() + " | Salario: " + e.calcularSalario());
            
            }
            
            
            
            //7. RECORRER CUENTA Y CALCULAR INTERES
            System.out.println("\n========INTERES DE CUENTAS========");
            Cuenta[] cuentas = {cuenta1, cuenta2, cuenta3};
            for (Cuenta c : cuentas) {
                System.out.println("N° Cuenta: " + c.getNumeroCuenta()+ " | Interes: " + c.calcularInteres());
            }
            
            
            
            
            //9. PERMISO DESDE CAJERO INSUFICIENTE
            System.out.println("\n========PERMISO========");
            try {
                Cajero miCajero = (Cajero) empleados[2];
                miCajero.aprobarCredito(cuenta3);
            } catch (PermisoInsuficienteException e) {
                System.out.println("¡ERROR! " + e.getMessage());
            }
            
            
            
            // 11. LLAMADO DE REGISTAR MODIFICACION
            System.out.println("\n========AUDITORIA========");
            cuenta1.registrarModificacion("Admin_01");
            System.out.println("Ultima Mod: " + cuenta1.obtenerUltimaModificacion());
            System.out.println("Usuario: " + cuenta1.obtenerUsuarioModificacion());

            
            

            // 12. NOMINA TOTAL
            System.out.println("\n========NOMINA TOTAL========");
            double totalNomina = 0;
            for (Empleado e : empleados) totalNomina += e.calcularSalario();
            System.out.println("Total a pagar: $" + totalNomina);

        } catch (Exception e) {
            System.err.println("Error general inesperado: " + e.getMessage());
            e.printStackTrace();
        }
            
            
        
            
        }
       
    }
    

