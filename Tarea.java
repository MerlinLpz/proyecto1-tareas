import java.time.LocalDate;

public class Tarea {

    private static final int LONGITUD_MINIMA_TITULO = 3;
    private static int siguienteId = 1;
     
    private final int id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private final LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private boolean completada;

    public Tarea(String titulo, String descripcion, Prioridad prioridad, LocalDate fechaEntrega) {
        setTitulo(titulo);   
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        setFechaEntrega(fechaEntrega);

        this.id = siguienteId++;
        this.fechaCreacion = LocalDate.now();
        this.completada = false;
     }

        public int getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public Prioridad getPrioridad() {
            return prioridad;
        }
 
        public LocalDate getFechaCreacion() {
            return fechaCreacion;
        }

        public LocalDate getFechaEntrega() {
            return fechaEntrega;
        }

        public boolean isCompletada() {
            return completada;
        }

        public void setTitulo(String titulo) {
            if (titulo == null || titulo.isBlank() || titulo.trim().length() < LONGITUD_MINIMA_TITULO) {
                throw new IllegalArgumentException("El titulo no puede estar vacio ni tener menos de  " + LONGITUD_MINIMA_TITULO + "caracteres");
            }
            this.titulo = titulo.trim();
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = (descripcion != null) ? descripcion.trim() : "";
        }

        public void setPrioridad(Prioridad prioridad) {
            if (prioridad == null) {
                throw new IllegalArgumentException("La prioridad no puede ser nulla.");
            }
            this.prioridad = prioridad;
        }

        public void setFechaEntrega(LocalDate fechaEntrega) {
            if (fechaEntrega != null && fechaEntrega.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha de entrega no puede ser anterio a hoy.");
            }
            this.fechaEntrega = fechaEntrega;
        }

        public boolean completar() {
            if (completada) {
                return false;
            }
            this.completada = true;
            return true;
        }
       
        public boolean descompletar() {
            if (!completada) {
                return false;
            }
            this.completada = false;
            return true;
        }

        @Override
        public String toString() {
            String estado = completada ? "[✅]" : "[ ]";
            String entrega = (fechaEntrega != null) ? fechaEntrega.toString() : "Sin fecha";

            return String.format("%s #%d | %-20s | %-6s | entrega: %s", estado, id, titulo, prioridad, entrega);
        }
}
