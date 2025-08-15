module com.example.codigos_postales_hmo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codigos_postales_hmo to javafx.fxml;
    exports com.example.codigos_postales_hmo;
}