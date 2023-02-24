module com.vttanh.qlthuvien {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vttanh.qlthuvien to javafx.fxml;
    exports com.vttanh.qlthuvien;
}
