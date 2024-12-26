module com.example.myunogame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.myunogame to javafx.fxml;
    exports com.example.myunogame;
}