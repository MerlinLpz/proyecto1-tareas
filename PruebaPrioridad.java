public class PruebaPrioridad {
    public static void main(String[] args) {

        Prioridad p = Prioridad.ALTA;
        System.out.println("Prioridad elejida: " + p);

        for (Prioridad valor : Prioridad.values()) {
            System.out.println(" - " + valor + " (posicion" + valor.ordinal() + ")");
        }

        switch (p) {
            case ALTA -> System.out.println("🔴 Urgente");
            case MEDIA -> System.out.println("🟡 Normal");
            case BAJA ->  System.out.println("🟢 Puede esperar");
        }
    }
}

