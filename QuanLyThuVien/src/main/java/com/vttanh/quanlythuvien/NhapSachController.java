/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.Sach;
import com.vttanh.pojo.TacGia;
import com.vttanh.pojo.TheLoai;
import com.vttanh.services.SachService;
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
public class NhapSachController implements Initializable {

    @FXML private Button Huy;
    @FXML private TextField txtTen;
    @FXML private TextField txtMoTa;
    @FXML private TextField txtNXB;
    @FXML private TextField txtSoLuong;
    @FXML private TextField txtSearch;
    @FXML private ComboBox <TheLoai> cbTheLoai;
    @FXML private ComboBox <TacGia> cbTacGia;
    @FXML private TableView<Sach> tbSach; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ThongTinChungService t = new ThongTinChungService();
         
        try {
            List<TheLoai> tl = t.getTheLoai();
            this.cbTheLoai.setItems(FXCollections.observableList(tl));
            
            List<TacGia> tg = t.getTacGia();
            this.cbTacGia.setItems(FXCollections.observableList(tg));
            
            this.loadTableColumns();
            this.loadTableData(null);
        } catch (SQLException ex) {
            Logger.getLogger(NhapSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtSearch.textProperty().addListener(d -> {
            try {
                this.loadTableData(this.txtSearch.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    public void nhapThongTinSach(ActionEvent evt) {
        Sach s = new Sach(this.txtTen.getText(),               
                this.txtMoTa.getText(),
                this.txtNXB.getText(),
                this.txtSoLuong.getText(),
                this.cbTheLoai.getSelectionModel().getSelectedItem().getId(),
                this.cbTacGia.getSelectionModel().getSelectedItem().getId());
                
        SachService p = new SachService();
        try {
            if ((txtTen.getText().isEmpty()) || (txtMoTa.getText().isEmpty()) || (txtNXB.getText().isEmpty()) || (txtSoLuong.getText().isEmpty()))
            {
               MessageBox.getBox("Thông báo", "Bạn chưa nhập thông tin!!!", Alert.AlertType.ERROR).show();
            }
            else
            {
                p.themSach(s);
                this.loadTableData(null);
                MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();
                Reset();
            }
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(NhapSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadTableColumns() {
        TableColumn colid = new TableColumn("STT");
        colid.setCellValueFactory(new PropertyValueFactory("id"));
        colid.setPrefWidth(80);
        
        TableColumn colname = new TableColumn("Tên sách");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(300);
        
        TableColumn colmt = new TableColumn("Mô tả");
        colmt.setCellValueFactory(new PropertyValueFactory("MoTa"));
        colmt.setPrefWidth(250);
        
        TableColumn colnxb = new TableColumn("NXB");
        colnxb.setCellValueFactory(new PropertyValueFactory("NXB"));
        colnxb.setPrefWidth(90);
        
        TableColumn colsl = new TableColumn("Số lượng");
        colsl.setCellValueFactory(new PropertyValueFactory("SoLuong"));
        colsl.setPrefWidth(90);
        
        this.tbSach.getColumns().addAll(colid, colname,colmt, colnxb, colsl);
    }
    
    private void loadTableData (String kw) throws SQLException{
        
        SachService s = new SachService();
        List<Sach> k = s.xemThongTinSach(kw);
        this.tbSach.setItems(FXCollections.observableList(k));
    }
    
    private void Reset() {
        txtTen.setText("");
        txtMoTa.setText("");
        txtNXB.setText("");
        txtSoLuong.setText("");
        cbTheLoai.getSelectionModel().clearSelection();
        cbTacGia.getSelectionModel().clearSelection();
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
