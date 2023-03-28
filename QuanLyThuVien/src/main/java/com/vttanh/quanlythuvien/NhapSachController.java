/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.Sach;
import com.vttanh.pojo.TheLoai;
import com.vttanh.services.SachService;
import com.vttanh.services.TheLoaiService;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class NhapSachController implements Initializable {

    @FXML private Button Huy;
    @FXML private TextField txtTen;
    @FXML private TextField txtMoTa;
    @FXML private TextField txtNXB;
    @FXML private TextField txtSoLuong;
    @FXML private ComboBox <TheLoai> cbTheLoai;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TheLoaiService t = new TheLoaiService();
         
        try {
            List<TheLoai> tl = t.getTheLoai();
            this.cbTheLoai.setItems(FXCollections.observableList(tl));
        } catch (SQLException ex) {
            Logger.getLogger(NhapSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void nhapThongTinSach(ActionEvent evt) {
        Sach s = new Sach(this.txtTen.getText(),               
                this.txtMoTa.getText(),
                this.txtNXB.getText(),
                this.txtSoLuong.getText(),
                this.cbTheLoai.getSelectionModel().getSelectedItem().getId());
        
        

        SachService p = new SachService();
        try {
            
            p.themSach(s);
            MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();
            Reset();
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(NhapSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Reset() {
        txtTen.setText("");
        txtMoTa.setText("");
        txtNXB.setText("");
        txtSoLuong.setText("");
    }
    
    public void Exit(ActionEvent event) throws Exception {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Thông báo");
        a.setHeaderText("Bạn muốn thoát?");
        Optional<ButtonType> re = a.showAndWait();
        if (re.get() == ButtonType.OK)
            {
                Stage stage = (Stage) Huy.getScene().getWindow();
                stage.close();
            }
    }
    
}
