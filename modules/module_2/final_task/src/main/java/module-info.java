module com.gnegdev.final_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gnegdev.final_2 to javafx.fxml;
    exports com.gnegdev.final_2;
}