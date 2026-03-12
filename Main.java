import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionPedidos sistema = new GestionPedidos();
        int opcion = -1;

        System.out.println(" BIENVENIDO A PIZZA MariaVic");

        while (opcion != 0) {
            System.out.println("\nMENÚ DE OPCIONES:");
            System.out.println("1. Registrar Pedido (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual (Peek)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la pizza: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrediente 1: ");
                        String i1 = sc.nextLine();
                        System.out.print("Ingrediente 2: ");
                        String i2 = sc.nextLine();
                        System.out.print("Ingrediente 3: ");
                        String i3 = sc.nextLine();
                        
                        Pizza nueva = new Pizza(nombre, i1, i2, i3);
                        sistema.registrarPedido(nueva);
                        break;

                    case 2:
                        sistema.undo();
                        break;

                    case 3:
                        sistema.redo();
                        break;

                    case 4:
                        sistema.mostrarActual();
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        sc.close();
    }
}
