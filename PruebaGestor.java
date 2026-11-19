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

        System.out.println("\n=== PRIORIDAD NULL ===");
        try {
            gestor.listarPorPrioridad(null);
        } catch(IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }

        System.out.println("\n=== ESTADO: pendientes y completadas ===");
        gestor.buscarPorId(1).ifPresent(Tarea::completar);

        System.out.println("Pendientes (" + gestor.listarPendientes().size() + "):");
        for (Tarea t : gestor.listarPendientes()) {
            System.out.println("   " + t);
        }

        System.out.println("Completadas (" + gestor.listarCompletadas().size() + "):");
        for (Tarea t : gestor.listarCompletadas()) {
            System.out.println("   " + t);
        }

        System.out.println("\n=== FILTRAR POR PRIORIDAD ===");
        System.out.println("ALTA  -> " + gestor.listarPorPrioridad(Prioridad.ALTA).size());
        System.out.println("MEDIA -> " + gestor.listarPorPrioridad(Prioridad.MEDIA).size());
        System.out.println("BAJA  -> " + gestor.listarPorPrioridad(Prioridad.BAJA).size());

        System.out.println("\n=== ELIMINAR ===");
        System.out.println("Tareas antes: " + gestor.contar());
        System.out.println("eliminar(1)  -> " + gestor.eliminar(1));
        System.out.println("eliminar(99) -> " + gestor.eliminar(99) + "   (no existe)");
        System.out.println("Tareas después: " + gestor.contar());

        System.out.println("\n=== ORDENADAS POR URGENCIA=====");
        gestor.agregar(new Tarea("Pagar Factura", "", Prioridad.ALTA, null));
        gestor.agregar(new Tarea("Ordenar Cajones", "", Prioridad.BAJA, null));
        gestor.agregar(new Tarea("Llamar al Banco", "", Prioridad.MEDIA, null));

        for (Tarea t : gestor.listarPorUrgencia()) {
            System.out.println("   " + t);
        }
    }
}
