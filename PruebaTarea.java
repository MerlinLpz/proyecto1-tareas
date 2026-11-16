import java.time.LocalDate;

public class PruebaTarea {
    public static void main(String[] args) {
        
        System.out.println("=== 1: Crear tareas validas. ===");
        Tarea t1 = new Tarea("Comprar pan", "En la panaderia de la esquina.", Prioridad.MEDIA, LocalDate.of(2026, 12, 1));
        Tarea t2 = new Tarea("Estudiar java", "Terminar el gestor de tareas", Prioridad.ALTA, null);
        Tarea t3 = new Tarea("Regar plantas", null, Prioridad.BAJA, LocalDate.of(2026, 11, 20));

        System.out.println(t1); 
        System.out.println(t2);
        System.out.println(t3);

        System.out.println("=== 2: Los ids se Generan solos ===");
        System.out.println("id de t1: " + t1.getId());
        System.out.println("id de t3: " + t3.getId());

        System.out.println("\n=== 3: Fecha de creacion automatica.===");
        System.out.println("t1 Creado el: " + t1.getFechaCreacion());

        System.out.println("\n=== 4. Titulo invalido. ===");
        try {
            new Tarea("ab", "demasiado corto", Prioridad.BAJA, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }

        System.out.println("\n=== 5. Prioridad nula ===");
        try {
            new Tarea("Tarea sin priorida", "x", null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }

        System.out.println("\n=== 6. Fecha de entrega en el pasado ===");
        try {
            new Tarea("Viaja al pasado", "x", Prioridad.ALTA, LocalDate.of(2020, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }

        System.out.println("\n=== 7. Completar y descompletar ===");
        System.out.println("Estado Inicial: " + t1);

        boolean cambio1 = t1.completar();
        System.out.println("1er completar() -> " + cambio1);
        System.out.println("             " + t1);

        boolean cambio2 = t1.completar();
        System.out.println("2do completar() -> " + cambio2 + " (ya estaba completada )");

        boolean cambio3 = t1.descompletar();
        System.out.println("Descompletar() -> " + cambio3);
        System.out.println("            " + t1);
        
        boolean cambio4 = t1.descompletar();
        System.out.println("2do descompletar() -> " + cambio4 + "   (ya estaba pendiente)");
    }
}
        
