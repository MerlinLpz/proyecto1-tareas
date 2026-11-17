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

        System.out.println("\n=== BUSCAR POR Id ===");
        gestor.buscarPorId(1).ifPresentOrElse(t -> System.out.println("Encontrado: " + t), () -> System.out.println("No Existe la tarea #1 "));

        gestor.buscarPorId(99).ifPresentOrElse(t -> System.out.println("Encontrado: " + t), () -> System.out.println("No Existe la tarea #99"));
        
        String titulo = gestor.buscarPorId(99)
        .map(Tarea::getTitulo)
        .orElse("(Sin Titulo)");
        System.out.println("Tuttulo de la #99: " + titulo);
    }
}
