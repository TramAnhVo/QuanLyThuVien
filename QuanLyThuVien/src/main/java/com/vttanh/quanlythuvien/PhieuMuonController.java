/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class PhieuMuonController implements Initializable {
    @FXML private Button Huy;
    @FXML private Label lbMaPhieu;
    @FXML private TextField txtTen;
    @FXML private DatePicker dateNgayMuon;
    @FXML private TextField txtMaSach;
    @FXML private TextField txtTenSach;
    @FXML private TextField txtSoLuong;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
