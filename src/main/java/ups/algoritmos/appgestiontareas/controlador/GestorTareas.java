package ups.algoritmos.appgestiontareas.controlador;

import ups.algoritmos.appgestiontareas.modelo.Tarea;

import java.util.*;

public class GestorTareas {
    //PILA Y COLA DE TAREAS PENDIENTES Y COMPLETADAS
    private Deque<Tarea> pilaPendientes;
    private Queue<Tarea> colaCompletadas;

    //CONSTRUCTOR
    public GestorTareas(){
        pilaPendientes = new ArrayDeque<>();
        colaCompletadas = new LinkedList<>();
    }

    //GETTERS Y SETTERS
    public List<Tarea> getPilaPendientes() {
        return new ArrayList<>(pilaPendientes);
    }

    public void setPilaPendientes(Deque<Tarea> pilaPendientes) {
        this.pilaPendientes = pilaPendientes;
    }

    public List<Tarea> getColaCompletadas() {
        return new ArrayList<>(colaCompletadas);
    }

    public void setColaCompletadas(Queue<Tarea> colaCompletadas) {
        this.colaCompletadas = colaCompletadas;
    }

    //-----------------METODOS ESPECIFICOS-------------------------------
    public void agregarTarea(String titulo, String descripcion){
        Tarea nuevaTarea = new Tarea(titulo, descripcion);
        pilaPendientes.push(nuevaTarea);
    }

    public void completarTarea(){
        if(!pilaPendientes.isEmpty()){
            Tarea tarea = pilaPendientes.pop();
            tarea.marcarComoCompletada();
            colaCompletadas.offer(tarea);
        }
    }

    public void eliminarTareaPendiente(){
        if(!pilaPendientes.isEmpty()){
            pilaPendientes.pop();
        }
    }

    public Tarea verProximaTarea(){
        return pilaPendientes.peek();
    }


}
