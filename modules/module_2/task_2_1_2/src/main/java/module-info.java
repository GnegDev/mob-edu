module com.gnegdev.cv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gnegdev.cv to javafx.fxml;
    exports com.gnegdev.cv;
}