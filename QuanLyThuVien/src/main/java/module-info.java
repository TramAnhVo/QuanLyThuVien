module com.vttanh.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.vttanh.quanlythuvien to javafx.fxml;
    exports com.vttanh.quanlythuvien;
}
