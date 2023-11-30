module com.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.farming.demo4 to javafx.fxml;

    exports com.farming.FarmDashboard;
    opens com.farming.FarmDashboard to javafx.fxml;
}