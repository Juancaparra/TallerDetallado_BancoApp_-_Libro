import java.util.Scanner;

// Excepción personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para montos inválidos
class MontoInvalidoException extends Exception {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Clase principal que interactúa con el usuario en la consola
public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear dos cuentas para realizar las operaciones
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan", 500.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Ronald", 300.0);

        int opcion;
        do {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Depositar en la cuenta de Ronald");
            System.out.println("2. Depositar en la cuenta de Juan");
            System.out.println("3. Retirar de la cuenta de Juan");
            System.out.println("4. Transferir de Juan a Ronald");
            System.out.println("5. Consultar saldos");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el monto a depositar a Ronald: ");
                        double deposito = scanner.nextDouble();
                        cuenta2.depositar(deposito);
                        break;

                    case 2:
                        System.out.print("Ingrese el monto a depositar a Juan: ");
                        deposito = scanner.nextDouble();
                        cuenta2.depositar(deposito);
                        break;

                    case 3:
                        System.out.print("Ingrese el monto a retirar: ");
                        double retiro = scanner.nextDouble();
                        cuenta1.retirar(retiro);
                        break;

                    case 4:
                        System.out.print("Ingrese el monto a retirar: ");
                        retiro = scanner.nextDouble();
                        cuenta1.retirar(retiro);
                        break;

                    case 5:
                        System.out.print("Ingrese el monto a transferir: ");
                        double transferencia = scanner.nextDouble();
                        cuenta1.transferir(cuenta2, transferencia);
                        break;

                    case 6:
                        System.out.println("Saldo de Juan: " + cuenta1.getSaldo());
                        System.out.println("Saldo de Ronald: " + cuenta2.getSaldo());
                        break;

                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (MontoInvalidoException | SaldoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 5);

        scanner.close();
    }
}
