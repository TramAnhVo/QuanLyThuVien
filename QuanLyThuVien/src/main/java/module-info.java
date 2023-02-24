module com.vttanh.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vttanh.quanlythuvien to javafx.fxml;
    exports com.vttanh.quanlythuvien;
}
