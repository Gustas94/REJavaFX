module com.example.rqengineering {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.rqengineering to javafx.fxml;
    exports com.example.rqengineering;
}