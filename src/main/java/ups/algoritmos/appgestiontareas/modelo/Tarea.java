package ups.algoritmos.appgestiontareas.modelo;

public class Tarea {

    //ATRIBUTOS DE LAS TAREAS
    private String titulo;
    private String descripcion;
    private boolean completada;

    //CONSTRUCTORES
    public Tarea() {
    }

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    //GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    //TOSTRING
    @Override
    public String toString(){
        return titulo + ": " + descripcion;
    }

    //-----------------------------METODOS ESPECIFICOS-------------------------------
    public void marcarComoCompletada(){
        this.completada = true;
    }

    public boolean estaCompletada(){
        return this.completada;
    }

}
