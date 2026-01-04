package ups.algoritmos.appgestiontareas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

   @Override
   public void start(Stage stage) throws IOException {

       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
               ("/ups/algoritmos/appgestiontareas/vista/interfaz_tareas.fxml"));

       Scene scene = new Scene(fxmlLoader.load(), 800, 600);

       scene.getStylesheets().add(getClass().getResource
               ("/ups/algoritmos/appgestiontareas/vista/estilos.css").toExternalForm());

       stage.setTitle("Gestor de Tareas");
       stage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/images/icon.png")));
       stage.setScene(scene);
       stage.show();
   }

    public static void main(String[] args) {
        launch();
    }
}
