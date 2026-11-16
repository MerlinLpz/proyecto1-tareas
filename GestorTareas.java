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
}
