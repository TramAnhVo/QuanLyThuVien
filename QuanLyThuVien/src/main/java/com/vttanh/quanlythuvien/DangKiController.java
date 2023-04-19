/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.BoPhan;
import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.DoiTuong;
import com.vttanh.pojo.GioiTinh;
import com.vttanh.services.ThongTinChungService;
import com.vttanh.services.ThongTin;
import com.vttanh.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class DangKiController implements Initializable {
    // đang ki thong tin doc gia 
    @FXML private ComboBox<DoiTuong> cbDoiTuong;
    @FXML private ComboBox<BoPhan> cbBoPhan;
    @FXML private ComboBox<GioiTinh> cbGioiTinh;
    @FXML private TextField txtHoTen;
    @FXML private TextField txtEmail;
    @FXML private TextField txtDiaChi;
    @FXML private TextField txtSDT;
    @FXML private DatePicker dateNgaySinh;
    // nap thong tin doc gia
    @FXML private Label lbHoTen1;
    @FXML private Label lbHanThe;
    @FXML private Label lbSDT1;
    @FXML private Label lbEmail1;
    @FXML private Label lbNgayDangKi;
    @FXML private Label lbNgaySinh;
    @FXML private Label lbDiaChi;
    // cac chuc nang
    @FXML private Button btHuy;
    @FXML private TextField txtSearchId;
    @FXML private TableView<DocGia> tbDocGia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ThongTinChungService s = new ThongTinChungService();
        try {
            List<DoiTuong> dt = s.getDoiTuongs();           
            this.cbDoiTuong.setItems(FXCollections.observableList(dt));
            List<BoPhan> bp = s.getBoPhan();
            this.cbBoPhan.setItems(FXCollections.observableList(bp));
            List<GioiTinh> gt = s.getGioiTinh();
            this.cbGioiTinh.setItems(FXCollections.observableList(gt));
            
            this.loadTableColumns();
            this.loadTableData();
        } catch (SQLException ex) {
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtSearchId.textProperty().addListener(f -> {
            try {
                this.loadThongTinCaNhan(this.txtSearchId.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void DangKiThongTin(ActionEvent evt) {        
        DocGia q;
        q = new DocGia(this.txtHoTen.getText(), 
                this.dateNgaySinh.getValue(),
                this.cbGioiTinh.getSelectionModel().getSelectedItem().getId(),
                this.txtEmail.getText(),
                this.txtSDT.getText(),
                this.txtDiaChi.getText(),
                this.cbDoiTuong.getSelectionModel().getSelectedItem().getId(),
                this.cbBoPhan.getSelectionModel().getSelectedItem().getId());

        ThongTin s = new ThongTin();
        try {
            if ((txtHoTen.getText().isEmpty()) || (txtDiaChi.getText().isEmpty()) || (txtEmail.getText().isEmpty())) {
                MessageBox.getBox("Thông báo", "Bạn chưa nhập thông tin!!!", Alert.AlertType.ERROR).show();
            }
            else 
            {
                if ( txtSDT.getLength() == 10 ) {
                    s.ThemThongTin(q);
                    Reset();
                    MessageBox.getBox("Thông báo", "Thêm thông tin thành công!!", Alert.AlertType.INFORMATION).show();                
                }
                else 
                {
                    MessageBox.getBox("Thông báo", "Nhập thông tin số điện thoại sai!!!", Alert.AlertType.ERROR).show();            
                } 
            }
                     
        } catch (SQLException ex) {
            MessageBox.getBox("Thông báo", "Thêm thông tin thất bại", Alert.AlertType.ERROR).show();
            Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Reset() {
        txtHoTen.clear();
        txtEmail.clear();
        txtDiaChi.clear();
        txtSDT.clear();
        cbGioiTinh.getSelectionModel().clearSelection();
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
        colns.setCellValueFactory(new PropertyValueFactory("NgaySinh1"));
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
        
        TableColumn colht = new TableColumn("Hạn thẻ");
        colht.setCellValueFactory(new PropertyValueFactory("HanThe"));
        colht.setPrefWidth(150);
        
        this.tbDocGia.getColumns().addAll(colid, colname,colns, colgt,colsdt, colndk, colht);
    }
    
    private void loadTableData () throws SQLException{
        ThongTin s = new ThongTin();
        List<DocGia> k = s.xemThongTinDocGia();
        this.tbDocGia.setItems(FXCollections.observableList(k));
    }
    
    public void loadThongTinCaNhan(String kw) throws SQLException {
        int mdg = Integer.parseInt(kw);
        ThongTin s = new ThongTin();
        
        String ten = s.TimkiemThongTinDocGia(mdg).get(0).getTen();
        Date ns = s.TimkiemThongTinDocGia(mdg).get(0).getNgaySinh1();
        String email = s.TimkiemThongTinDocGia(mdg).get(0).getEmail();
        String sdt = s.TimkiemThongTinDocGia(mdg).get(0).getSDT();
        String dc = s.TimkiemThongTinDocGia(mdg).get(0).getDiaChi();
        Date ndk = s.TimkiemThongTinDocGia(mdg).get(0).getNgayDangKi1();
        Date ht = s.TimkiemThongTinDocGia(mdg).get(0).getHanThe1();
        
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String ngSinh = f.format(ns);
        String ngDKi = f.format(ndk);
        String HanThe = f.format(ht);
        
        lbHoTen1.setText(ten);
        lbNgaySinh.setText(ngSinh);
        lbEmail1.setText(email);
        lbSDT1.setText(sdt);
        lbDiaChi.setText(dc);
        lbNgayDangKi.setText(ngDKi);
        lbHanThe.setText(HanThe);
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
