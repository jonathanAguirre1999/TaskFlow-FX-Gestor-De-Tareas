package ups.algoritmos.appgestiontareas.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ups.algoritmos.appgestiontareas.modelo.Tarea;

public class InterfazTareasController {
    //ACCESO AL CONTROLADOR DE TAREAS
    GestorTareas gestor = new GestorTareas();

    //ELEMENTOS DE LA GUI
    @FXML private ListView <Tarea> listaPendientes;
    @FXML private ListView <Tarea> listaCompletadas;
    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescripcion;
    @FXML private Label lblProxima;

    //INICIO DE GUI
    @FXML
    public void initialize(){
        actualizarListas();
    }

    @FXML
    public void onAgregar(ActionEvent event){
        String titulo = txtTitulo.getText();
        String descripcion = txtDescripcion.getText();
        if(!titulo.isEmpty() && !descripcion.isEmpty()){
            gestor.agregarTarea(titulo, descripcion);
            actualizarListas();
            txtTitulo.clear();
        }
    }

    @FXML
    public void onCompletar(ActionEvent event){
        gestor.completarTarea();
        actualizarListas();
    }

    @FXML
    public void onEliminar(ActionEvent event){
        gestor.eliminarTareaPendiente();
        actualizarListas();
    }

    @FXML
    public void onVerProxima(ActionEvent event){
        Tarea t = gestor.verProximaTarea();
        if(t != null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Próxima tarea");
            alert.setHeaderText("A chambear");
            alert.setContentText("Tu siguiente tarea a realizar es:\n" + t.toString());
            alert.showAndWait();
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Eres libre");
            alert.setHeaderText("Sin tareas pendientes");
            alert.setContentText
                    ("Has completado todas tus tareas pendientes, puedes descansar o agregar nuevas tareas");
            alert.showAndWait();
        }
    }

    /*public void alternarModoOscuro(ActionEvent event){

    }*/


    private void actualizarListas(){
        listaPendientes.getItems().setAll(gestor.getPilaPendientes());
        listaCompletadas.getItems().setAll(gestor.getColaCompletadas());
    }


    //GETTERS Y SETTERS
    public ListView<Tarea> getListaPendientes() {
        return listaPendientes;
    }

    public void setListaPendientes(ListView<Tarea> listaPendientes) {
        this.listaPendientes = listaPendientes;
    }

    public ListView<Tarea> getListaCompletadas() {
        return listaCompletadas;
    }

    public void setListaCompletadas(ListView<Tarea> listaCompletadas) {
        this.listaCompletadas = listaCompletadas;
    }


}
