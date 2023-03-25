/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.PhieuMuon;
import com.vttanh.services.MuonService;
import com.vttanh.services.ThongTin;
import com.vttanh.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class PhieuMuonController implements Initializable {
    @FXML private Button Huy;
    @FXML private Label lbMaPhieu;
    @FXML private TextField txtTen;
    @FXML private DatePicker dateNgayMuon;
    @FXML private TextField txtSDT;
    @FXML private TextField txtTenSach;
    @FXML private TextField txtSoLuong;
    @FXML private TextField txtTong;
    @FXML private TextField txtSearch;
    @FXML private TableView<PhieuMuon> tbPhieuMuon;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            this.loadTableColumns();
            this.loadTableData(null);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtSearch.textProperty().addListener(d -> {
            try {
                this.loadTableData(this.txtSearch.getText());
            } catch (SQLException ex) {
                Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } 
    
    public void themPhieuMuon (ActionEvent evt) {
        PhieuMuon k = new PhieuMuon(
                this.txtTen.getText(),
                this.dateNgayMuon.getValue(),
                this.txtSDT.getText(),
                this.txtTong.getText());
       
        MuonService s = new MuonService();
        try {
            s.themPhieuMuon(k);
            this.loadTableData(null);
            MessageBox.getBox("Thông báo", "Thêm phiếu mượn thành công!!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm phiếu mượn thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void loadTableColumns() {
        TableColumn colid = new TableColumn("STT");
        colid.setCellValueFactory(new PropertyValueFactory("id"));
        colid.setPrefWidth(80);
        
        TableColumn colname = new TableColumn("Họ và tên độc giả");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(200);
        
        TableColumn colsdt = new TableColumn("Số điện thoại");
        colsdt.setCellValueFactory(new PropertyValueFactory("SDT"));
        colsdt.setPrefWidth(150);
        
        TableColumn colsl = new TableColumn("Tổng sách mượn");
        colsl.setCellValueFactory(new PropertyValueFactory("SL"));
        colsl.setPrefWidth(150);
        
        this.tbPhieuMuon.getColumns().addAll(colid, colname,colsdt, colsl);
    }
    
    private void loadTableData (String kw) throws SQLException{
        MuonService s = new MuonService();
        List<PhieuMuon> k = s.xemThongTinPhieuMuon(kw);
        this.tbPhieuMuon.setItems(FXCollections.observableList(k));
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
