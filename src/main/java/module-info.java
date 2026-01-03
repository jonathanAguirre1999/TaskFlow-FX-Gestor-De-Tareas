module ups.algoritmos.appgestiontareas {
    requires javafx.controls;
    requires javafx.fxml;


    opens ups.algoritmos.appgestiontareas to javafx.fxml;
    exports ups.algoritmos.appgestiontareas;
    exports ups.algoritmos.appgestiontareas.controlador;
    opens ups.algoritmos.appgestiontareas.controlador to javafx.fxml;
}