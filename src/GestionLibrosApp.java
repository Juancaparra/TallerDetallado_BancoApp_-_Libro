import java.util.List;
import java.util.Scanner;

public class GestionLibrosApp {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Leer libro por ID");
            System.out.println("3. Leer todos los libros");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("ID del libro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    Libro libro = new Libro(id, titulo, autor, anio);
                    libroDAO.crear(libro);
                    break;

                case 2:
                    System.out.print("ID del libro a leer: ");
                    int idLeer = scanner.nextInt();
                    Libro libroLeido = libroDAO.leer(idLeer);
                    if (libroLeido != null) {
                        System.out.println(libroLeido);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 3:
                    List<Libro> libros = libroDAO.leerTodos();
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros.");
                    } else {
                        libros.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("ID del libro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo título del libro: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nuevo autor del libro: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Nuevo año de publicación: ");
                    int nuevoAnio = scanner.nextInt();
                    Libro libroActualizado = new Libro(idActualizar, nuevoTitulo, nuevoAutor, nuevoAnio);
                    libroDAO.actualizar(libroActualizado);
                    break;

                case 5:
                    System.out.print("ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroDAO.eliminar(idEliminar);
                    break;

                case 6:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}

