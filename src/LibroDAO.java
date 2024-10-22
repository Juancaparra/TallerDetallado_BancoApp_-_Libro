import java.util.List;

public interface LibroDAO {
    void crear(Libro libro);
    Libro leer(int id);
    List<Libro> leerTodos();
    void actualizar(Libro libro);
    void eliminar(int id);
}
