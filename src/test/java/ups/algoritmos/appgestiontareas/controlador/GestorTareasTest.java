package ups.algoritmos.appgestiontareas.controlador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ups.algoritmos.appgestiontareas.modelo.Tarea;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestorTareasTest {
    private GestorTareas gestor;

    // LIMPIA EL GESTOR ANTES DE CADA TEST
    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    @DisplayName("CASO: agrega correctamente tareas a la pila de tareas pendientes")
    void testAgregarTarea() {
        gestor.agregarTarea("Comprar Pan", "Ir a la panadería");

        List<Tarea> pendientes = gestor.getPilaPendientes();
        assertEquals(1, pendientes.size(), "La lista debería tener 1 tarea");
        assertEquals("Comprar Pan", pendientes.get(0).getTitulo(), "El título no coincide");
    }

    @Test
    @DisplayName("CASO: comprobar comportamiento de la pila LIFO")
    void testComportamientoPilaLIFO() {
        gestor.agregarTarea("Tarea 1", "D1");
        gestor.agregarTarea("Tarea 2", "D2");
        gestor.agregarTarea("Tarea 3", "D3");

        Tarea proxima = gestor.verProximaTarea();

        assertNotNull(proxima);
        assertEquals("Tarea 3", proxima.getTitulo(), "La próxima tarea debería ser la última que se agregó");
    }

    @Test
    @DisplayName("CASO: al completar una tarea esta se elimina de la pila y pasa a la cola de historial")
    void testCompletarTarea() {
        gestor.agregarTarea("Estudiar", "Urgente");

        gestor.completarTarea();

        assertTrue(gestor.getPilaPendientes().isEmpty(), "La pila de pendientes debería estar vacía");
        assertEquals(1, gestor.getColaCompletadas().size(), "La cola de completadas debería tener 1 elemento");
        assertTrue(gestor.getColaCompletadas().get(0).estaCompletada(), "El estado de la tarea debería ser 'completada'");
    }

    @Test
    @DisplayName("CASO: la cola de historial de tareas completadas debe tener comportamiento FIFO")
    void testComportamientoColaFIFO() {
        gestor.agregarTarea("Tarea 1", "D");
        gestor.completarTarea(); // Tarea 1 va al historial

        gestor.agregarTarea("Tarea 2", "D");
        gestor.completarTarea(); // Tarea 2 va al historial

        List<Tarea> historial = gestor.getColaCompletadas();

        assertEquals("Tarea 1", historial.get(0).getTitulo(), "El historial debe respetar el orden FIFO");
        assertEquals("Tarea 2", historial.get(1).getTitulo());
    }

    @Test
    @DisplayName("CASO: comportamiento con listas vacías")
    void testListasVacias() {
        assertDoesNotThrow(() -> gestor.eliminarTareaPendiente());
        assertDoesNotThrow(() -> gestor.completarTarea());

        assertNull(gestor.verProximaTarea(), "Debería devolver null si no hay tareas");
    }
}