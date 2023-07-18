module com.example.demobudgetapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.app to javafx.fxml;
    exports com.example.app;
}