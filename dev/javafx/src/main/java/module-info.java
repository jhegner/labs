module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires javafx.graphics;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
}