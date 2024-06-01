module com.example.tugas5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tugas5 to javafx.fxml;
    exports com.example.tugas5;
}