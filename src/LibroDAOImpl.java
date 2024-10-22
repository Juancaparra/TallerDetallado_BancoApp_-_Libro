import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void crear(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    @Override
    public Libro leer(int id) {
        return libros.stream()
                .filter(libro -> libro.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Libro> leerTodos() {
        return new ArrayList<>(libros);
    }

    @Override
    public void actualizar(Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                System.out.println("Libro actualizado: " + libro);
                return;
            }
        }
        System.out.println("No se encontró el libro con id: " + libro.getId());
    }

    @Override
    public void eliminar(int id) {
        libros.removeIf(libro -> libro.getId() == id);
        System.out.println("Libro eliminado con id: " + id);
    }
}
