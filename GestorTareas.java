import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorTareas {
    
    private final List<Tarea> tareas = new ArrayList<>();

    public void agregar(Tarea tarea) {
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no puede ser null.");
        }
        tareas.add(tarea);   
    }

    public List<Tarea> listarTodas() {
        return new ArrayList<>(tareas);
    }

    public int contar() {
        return tareas.size();
    }

    public Optional<Tarea> buscarPorId(int id) {
        return tareas.stream()
        .filter(t -> t.getId() == id)
        .findFirst();
    }

    public boolean eliminar(int id) {
        return tareas.removeIf(t -> t.getId() == id);
    }

    public List<Tarea> listarPendientes() {
        return tareas.stream()
        .filter(t ->  !t.isCompletada())
        .toList();
    }
 
    public List<Tarea> listarCompletadas() {
        return tareas.stream()
        .filter(t -> t.isCompletada())
        .toList();
    }

    public List<Tarea> listarPorPrioridad(Prioridad prioridad) {
        if (prioridad == null) {
            throw new IllegalArgumentException("La prioridad no puede ser null.");
        }
        return tareas.stream()
        .filter(t -> t.getPrioridad() == prioridad)
        .toList();
    }
}
