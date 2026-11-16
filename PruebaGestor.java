import java.util.List;

public class PruebaGestor {
    public static void main(String[] args) {
   
        GestorTareas gestor = new GestorTareas();

        gestor.agregar(new Tarea("Comprar Pan", "", Prioridad.MEDIA, null));
        gestor.agregar(new Tarea("Estudiar JAVA", "", Prioridad.ALTA, null));
        System.out.println("Tareas: " + gestor.contar());

        List<Tarea> copia = gestor.listarTodas();
        copia.clear();
        System.out.println("Tras vaciar la copia: " + gestor.contar());

        try {
            gestor.agregar(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
    }
}
