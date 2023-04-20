/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.BoPhan;
import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.DoiTuong;
import com.vttanh.pojo.PhieuMuon;
import com.vttanh.pojo.PhieuMuonChiTiet;
import com.vttanh.pojo.Sach;
import com.vttanh.services.ThongTinChungService;
import com.vttanh.services.MuonService;
import com.vttanh.services.PhieuMuonChiTietService;
import com.vttanh.services.SachService;
import com.vttanh.services.ThongTin;
import com.vttanh.utils.MessageBox;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class PhieuMuonController implements Initializable {
    
     @FXML
    private Button Huy;
    @FXML
    private TextField txtTen;
    @FXML
    private DatePicker dateNgayMuon;
    @FXML
    private TextField txtTenSach;
    @FXML
    private TextField txtSoLuong;

    @FXML
    private TableView<PhieuMuonChiTiet> tbPhieuMuon;

    @FXML
    private TextField txtid;

    private ObservableList<PhieuMuonChiTiet> dspmct = FXCollections.observableArrayList();
    int sl = 0;
    MuonService m = new MuonService();
    PhieuMuonChiTietService pmcts = new PhieuMuonChiTietService();
    SachService sach = new SachService();
    ThongTin docgia = new ThongTin();
    PhieuMuonChiTiet pmct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadTableView();
        this.loadTableColumns();

        this.txtid.textProperty().addListener(d -> {
            try {
                int id = Integer.parseInt(txtid.getText());
                String ten = docgia.xemThongTinDocGiaByID(id).get(0).getTen();
                txtTen.setText(ten);
            } catch (SQLException ex) {
                Logger.getLogger(PhieuTraController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void themPhieuMuon(ActionEvent evt) throws SQLException {
        List<Sach> dssach = sach.xemThongTinSach(txtTenSach.getText());
        int id_docgia = Integer.parseInt(txtid.getText());
        List<DocGia> dsdg = docgia.xemThongTinDocGiaByID(id_docgia);

        List<PhieuMuon> dspm = m.getPhieuMuonByid_DocGia(id_docgia);

        if (dspm.size() != 0) {
            MessageBox.getBox("Thông báo", "Đọc giả chưa trả hết sách đã mượn!!", Alert.AlertType.ERROR).show();

        } else {
            Date hanThe = (Date)dsdg.get(0).getHanThe1();

            Date hienTai = Date.valueOf(LocalDate.now());

            int result = hanThe.compareTo(hienTai);

            if (result >= 0) {

                if (dssach.size() == 1) {

                    int idsach = dssach.get(0).getId();
                    pmct = new PhieuMuonChiTiet(txtTenSach.getText(), txtSoLuong.getText(), txtSoLuong.getText(), 0, idsach);
                    int slt = Integer.parseInt(txtSoLuong.getText());

                    if (slt < 6 && sl < 9) {
                        dspmct.add(pmct);
                        int slm = Integer.parseInt(pmct.getSL());
                        sl = slm + slt;
                  
                    } else {
                        MessageBox.getBox("Thông báo", "Số lượng sách vượt quá quy định!!", Alert.AlertType.ERROR).show();
                    }

                    loadTableView();
                    txtTenSach.setText("");
                    txtSoLuong.setText("");

                } else {
                    MessageBox.getBox("Thông báo", "Sách không tồn tại!!", Alert.AlertType.ERROR).show();
                }

            } else {
                MessageBox.getBox("Thông báo", "Quá hạn thẻ!!", Alert.AlertType.ERROR).show();
            }
        }
    }

    public void themPhieuChiTiet(ActionEvent evt) throws SQLException {
        List<DocGia> dsdg = docgia.xemThongTinDocGia(txtTen.getText());

        if (dsdg.size() == 1) {

            if (dspmct.size() != 0) {

                int iddg = dsdg.get(0).getId();
                PhieuMuon b = new PhieuMuon(txtTen.getText(), dateNgayMuon.getValue(), 0, iddg);

                try {
                    m.themPhieuMuonSach(b);

                    for (PhieuMuonChiTiet p : dspmct) {
                        p.setId_PhieuMuon(b.getId());
                    }

                    pmcts.themPhieuMCT(dspmct);
                    txtid.setText("");
                    txtTen.setText("");
                    dspmct.clear();
                    MessageBox.getBox("Thông báo", "Thêm thành công!!", Alert.AlertType.INFORMATION).show();

                } catch (SQLException ex) {
                    MessageBox.getBox("Thông báo", "Thêm thất bại", Alert.AlertType.ERROR).show();
                    Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                MessageBox.getBox("Thông báo", "Chưa thêm sách muốn mượn!!", Alert.AlertType.ERROR).show();
            }
        }
    }

    private void loadTableColumns() {
        TableColumn colname = new TableColumn("Tên Sách");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(200);

        TableColumn colnm = new TableColumn("Số Lượng");
        colnm.setCellValueFactory(new PropertyValueFactory("SL"));
        colnm.setPrefWidth(200);

        this.tbPhieuMuon.getColumns().addAll(colname, colnm);
    }

    public void loadTableView() {
        if (dspmct.size() > 0) {
//            tbv_Product.getItems().clear();
            tbPhieuMuon.setItems(FXCollections.observableList(dspmct));

        }
    }

    public void Exit(ActionEvent event) throws Exception {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Thông báo");
        a.setHeaderText("Bạn muốn thoát?");
        Optional<ButtonType> re = a.showAndWait();
        if (re.get() == ButtonType.OK) {
            Stage stage = (Stage) Huy.getScene().getWindow();
            stage.close();
        }
    }

    public void Reset() {
        txtTen.setText("");
    }
}
