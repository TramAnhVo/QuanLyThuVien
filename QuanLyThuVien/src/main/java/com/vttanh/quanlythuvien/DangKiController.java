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
    @FXML private TextField txtSearch;
    @FXML private TableView<DocGia> tbDocGia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DoiTuongServices s = new DoiTuongServices();
        BoPhanService x = new BoPhanService();
        try {
            List<DoiTuong> dt = s.getDoiTuongs();           
            this.cbDoiTuong.setItems(FXCollections.observableList(dt));
            List<BoPhan> bp = x.getBoPhan();
            this.cbBoPhan.setItems(FXCollections.observableList(bp));
            
            this.loadTableColumns();
            this.loadTableData(null);
        } catch (SQLException ex) {
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtSearch.textProperty().addListener(d -> {
            try {
                this.loadTableData(this.txtSearch.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void DangKiThongTin(ActionEvent evt) {        
        DocGia q;
        q = new DocGia(this.txtHoTen.getText(), 
                this.dateNgaySinh.getValue(),
                this.txtGT.getText(),
                this.txtEmail.getText(),
                this.txtSDT.getText(),
                this.txtDiaChi.getText(),
                this.cbDoiTuong.getSelectionModel().getSelectedItem().getId(),
                this.cbBoPhan.getSelectionModel().getSelectedItem().getId());

        ThongTin s = new ThongTin();
        try {
//            if ((txtGT.getText() != "Nam") || (txtGT.getText() != "Nữ")  ) {
//            MessageBox.getBox("Thông báo", "Nhập thông tin sai", Alert.AlertType.ERROR).show();
//            }
                       
                s.ThemThongTin(q);
                this.loadTableData(null);
                Reset();
                MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();
           
               MessageBox.getBox("Thông báo", "Nhập thông tin sai", Alert.AlertType.ERROR).show(); 
            
            //s.ThemThongTin(q);
            
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void ktGioiTinh() {
//        if ((txtGT.getText() == "Nam") || (txtGT.getText() == "Nữ")  ) {
//            //MessageBox.getBox("Thông báo", "Nhập thông tin sai", Alert.AlertType.ERROR).show();
//            txtGT.setText("");
//        } 
//    }
    
    private void Reset() {
        txtHoTen.clear();
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtGT.setText("");
        cbBoPhan.getSelectionModel().clearSelection();
        cbDoiTuong.getSelectionModel().clearSelection();
    }
    
    private void loadTableColumns() {
        TableColumn colid = new TableColumn("STT");
        colid.setCellValueFactory(new PropertyValueFactory("id"));
        colid.setPrefWidth(85);
        
        TableColumn colname = new TableColumn("Họ và tên độc giả");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(220);
        
        TableColumn colns = new TableColumn("Ngày sinh");
        colns.setCellValueFactory(new PropertyValueFactory("NgaySinh"));
        colns.setPrefWidth(150);
        
        TableColumn colgt = new TableColumn("Giới tính");
        colgt.setCellValueFactory(new PropertyValueFactory("GT"));
        colgt.setPrefWidth(105);
        
        TableColumn colsdt = new TableColumn("Số điện thoại");
        colsdt.setCellValueFactory(new PropertyValueFactory("SDT"));
        colsdt.setPrefWidth(150);
        
        TableColumn colndk = new TableColumn("Ngày đăng kí");
        colndk.setCellValueFactory(new PropertyValueFactory("NgayDangKi"));
        colndk.setPrefWidth(150);
        
        this.tbDocGia.getColumns().addAll(colid, colname,colns, colgt,colsdt, colndk);
    }
    
    private void loadTableData (String kw) throws SQLException{
        ThongTin s = new ThongTin();
        List<DocGia> k = s.xemThongTinDocGia(kw);
        this.tbDocGia.setItems(FXCollections.observableList(k));
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
