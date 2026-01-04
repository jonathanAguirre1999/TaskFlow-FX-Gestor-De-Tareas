package ups.algoritmos.appgestiontareas.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ups.algoritmos.appgestiontareas.modelo.Tarea;

public class InterfazTareasController {
    //ACCESO AL CONTROLADOR DE TAREAS
    GestorTareas gestor = new GestorTareas();

    //ELEMENTOS DE LA GUI
    @FXML private VBox contenedorPrincipal;
    @FXML private ListView <Tarea> listaPendientes;
    @FXML private ListView <Tarea> listaCompletadas;
    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescripcion;
    @FXML private Button btnEliminar;
    @FXML private ToggleButton btnModoOscuro;

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
            txtDescripcion.clear();
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
            alert.setTitle("A chambear");
            alert.setHeaderText("Próxima tarea");
            alert.setContentText("Tu siguiente tarea a realizar es: " + t.toString());

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));

            alert.showAndWait();
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sin tareas pendientes");
            alert.setHeaderText("Eres libre");
            alert.setContentText
                    ("Has completado todas tus tareas pendientes, puedes descansar o agregar nuevas tareas");

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));

            alert.showAndWait();
        }
    }

    public void alternarModoOscuro(ActionEvent event){
        if(btnModoOscuro.isSelected()){
            contenedorPrincipal.getStyleClass().add("dark-mode");
            btnModoOscuro.setText("Modo Claro");
        } else{
            contenedorPrincipal.getStyleClass().remove("dark-mode");
            btnModoOscuro.setText("Modo Oscuro");
        }
    }


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
