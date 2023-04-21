/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.DatSach;
import com.vttanh.pojo.GioiTinh;
import com.vttanh.services.DatSachServices;
import com.vttanh.services.ThongTinChungService;
import com.vttanh.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class DatSachController implements Initializable {

    @FXML
    private TextField txtTen;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtSL;
    @FXML
    private DatePicker dateNgayDat;
    @FXML
    private Button btHuy;
    @FXML
    private ComboBox<GioiTinh> cbGioiTinh;
    @FXML
    private TableView<DatSach> tbDatSach;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ThongTinChungService f = new ThongTinChungService();
        try {
            List<GioiTinh> gt = f.getGioiTinh();
            this.cbGioiTinh.setItems(FXCollections.observableList(gt));

            this.loadTable();
            this.loadData();
        } catch (SQLException ex) {
            Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DangkiDatSach(ActionEvent evt) {
        DatSach q;
        q = new DatSach(this.txtTen.getText(),
                this.cbGioiTinh.getSelectionModel().getSelectedItem().getId(),
                this.txtSDT.getText(),
                this.txtEmail.getText(),
                this.dateNgayDat.getValue(),
                this.txtSL.getText());

        DatSachServices s = new DatSachServices();
        try {
            if ((txtTen.getText().isEmpty()) || (txtSL.getText().isEmpty())
                    || (txtTen.getText().startsWith(" ")) && txtTen.getText().matches("\\d+") == false
                    || (txtEmail.getText().isEmpty())) {
                MessageBox.getBox("Thông báo", "Bạn chưa nhập thông tin!!!!", Alert.AlertType.ERROR).show();
            } else {
                if (txtSDT.getLength() == 10 && txtSDT.getText().matches("\\d+") == true
                        && txtSDT.getText().startsWith("0") == true) 
                    {      
                        int so = Integer.parseInt(txtSL.getText());
                    if (txtSL.getLength() == 1 && txtSL.getText().matches("\\d+") == true
                            && txtSL.getText().startsWith("0") == false
                            && so < 6) {
                        s.themDatSach(q);
                        this.loadData();
                        Reset();
                        MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();
                    } else {
                        MessageBox.getBox("Thông báo", "Nhập thông tin số lượng sai!!!", Alert.AlertType.ERROR).show();
                    }
                } else {
                    MessageBox.getBox("Thông báo", "Nhập số điện thoại sai!!!!", Alert.AlertType.ERROR).show();
                }
            }
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Reset() {
        txtTen.clear();
        txtEmail.clear();
        txtSDT.clear();
        txtSL.clear();
        cbGioiTinh.getSelectionModel().clearSelection();
    }

    public void Exit(ActionEvent event) throws Exception {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Thông báo");
        a.setHeaderText("Bạn muốn thoát?");
        Optional<ButtonType> re = a.showAndWait();
        if (re.get() == ButtonType.OK) {
            Stage stage = (Stage) btHuy.getScene().getWindow();
            stage.close();
        }
    }

    private void loadTable() {
        TableColumn colid = new TableColumn("STT");
        colid.setCellValueFactory(new PropertyValueFactory("id"));
        colid.setPrefWidth(100);

        TableColumn colname = new TableColumn("Họ và tên độc giả");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(220);

        TableColumn colgt = new TableColumn("Giới tính");
        colgt.setCellValueFactory(new PropertyValueFactory("GT"));
        colgt.setPrefWidth(105);

        TableColumn colsdt = new TableColumn("Số điện thoại");
        colsdt.setCellValueFactory(new PropertyValueFactory("SDT"));
        colsdt.setPrefWidth(150);

        TableColumn colemail = new TableColumn("Email");
        colemail.setCellValueFactory(new PropertyValueFactory("Email"));
        colemail.setPrefWidth(200);

        TableColumn colnds = new TableColumn("Ngày đặt sách");
        colnds.setCellValueFactory(new PropertyValueFactory("NgayDat"));
        colnds.setPrefWidth(150);

        this.tbDatSach.getColumns().addAll(colid, colname, colgt, colsdt, colemail, colnds);
    }

    private void loadData() throws SQLException {
        DatSachServices s = new DatSachServices();
        List<DatSach> k = s.xemThongTinDatSach();
        this.tbDatSach.setItems(FXCollections.observableList(k));
    }
}
