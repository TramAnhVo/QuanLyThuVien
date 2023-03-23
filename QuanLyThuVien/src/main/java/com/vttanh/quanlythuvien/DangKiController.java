/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.BoPhan;
import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.DoiTuong;
import com.vttanh.services.BoPhanService;
import com.vttanh.services.ThongTin;
import com.vttanh.services.DoiTuongServices;
import com.vttanh.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class DangKiController implements Initializable {

    @FXML private ComboBox<DoiTuong> cbDoiTuong;
    @FXML private ComboBox<BoPhan> cbBoPhan;
    @FXML private TextField txtHoTen;
    @FXML private TextField txtGT;
    @FXML private TextField txtEmail;
    @FXML private TextField txtDiaChi;
    @FXML private TextField txtSDT;
    @FXML private DatePicker dateNgaySinh;
    @FXML private Button btHuy;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DoiTuongServices s = new DoiTuongServices();
        BoPhanService x = new BoPhanService();
        try {
            List<DoiTuong> dt = s.getDoiTuongs();           
            this.cbDoiTuong.setItems(FXCollections.observableList(dt));
            List<BoPhan> bp = x.getBoPhan();
            this.cbBoPhan.setItems(FXCollections.observableList(bp));
        } catch (SQLException ex) {
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public void DangKiThongTin(ActionEvent evt) {
        DocGia q = new DocGia(this.txtHoTen.getText(), 
                this.dateNgaySinh.getValue(), 
                this.txtGT.getText(),              
                this.txtEmail.getText(),
                this.txtSDT.getText(),
                this.txtDiaChi.getText(),
                this.cbDoiTuong.getSelectionModel().getSelectedItem().getId(),
                this.cbBoPhan.getSelectionModel().getSelectedItem().getId());

        ThongTin s = new ThongTin();
        try {
            s.ThemThongTin(q);
            MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void Exit(ActionEvent event) throws Exception {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Thông báo");
        a.setHeaderText("Bạn muốn thoát?");
        Optional<ButtonType> re = a.showAndWait();
        if (re.get() == ButtonType.OK)
            {
                Stage stage = (Stage) btHuy.getScene().getWindow();
                stage.close();
            }
    }
}
