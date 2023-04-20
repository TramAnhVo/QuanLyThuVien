/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.PhieuMuon;
import com.vttanh.pojo.PhieuMuonChiTiet;
import com.vttanh.pojo.PhieuTra;
import com.vttanh.services.MuonService;
import com.vttanh.services.PhieuMuonChiTietService;
import com.vttanh.services.PhieuTraService;
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
import javafx.scene.control.ButtonType;
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
public class PhieuTraController implements Initializable {
     @FXML
    private javafx.scene.control.Button Huy;
    @FXML
    private TextField txtTen;
    @FXML
    private DatePicker dateNgayMuon;
    @FXML
    private TextField txtTenSach;
    @FXML
    private TextField txtSoLuong;
    @FXML
    private TableView<PhieuMuonChiTiet> tbPhieuTra;

    @FXML
    private TextField txtid;

    MuonService s = new MuonService();
    PhieuMuonChiTietService pmcts = new PhieuMuonChiTietService();
    PhieuTraService pts = new PhieuTraService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        try {
        this.loadTableColumns();
//        } catch (SQLException ex) {
//            Logger.getLogger(PhieuTraController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        this.txtid.textProperty().addListener(d -> {
            try {
                this.loadData(txtid.getText());
                int id = Integer.parseInt(txtid.getText());
                String ten = s.getPhieuMuonByid_DocGia(id).get(0).getTen();
                txtTen.setText(ten);
            } catch (SQLException ex) {
                Logger.getLogger(PhieuTraController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

//    public int CheckTienPhat() throws SQLException {
//
//        int ngay = 0;
//        int id = Integer.parseInt(txtid.getText());
//
//        List<PhieuMuon> dspm = s.getPhieuMuonByid_DocGia(id);
//
////       chuyển kiểu date -> localdate
//        Date ngayMuon = (Date) dspm.get(0).getNgayMuon1();
//        Date hienTai = Date.valueOf(LocalDate.now());
////        long soNgay = ChronoUnit.DAYS.between(hienTai.toInstant(), ngayMuon.toInstant());
////         Instant instant = ngaym.toInstant();
////         ZoneId zone = ZoneId.systemDefault();  //Lấy múi giờ mặc định
////         ZonedDateTime zdt = instant.atZone(zone);
////         LocalDate ngayMuon = zdt.toLocalDate();
//
////      Chuyển đổi từ Date sang LocalDateTime
////        LocalDateTime localDateTime = LocalDateTime.ofInstant(ngaym.toInstant(), java.time.ZoneId.systemDefault());
//        // Chuyển đổi từ LocalDateTime sang LocalDate
////        LocalDate ngayMuon = localDateTime.toLocalDate();
////        LocalDate hienTai = LocalDate.now();
////        Period period = Period.between(ngayMuon, hienTai);
////        int days = period.getDays();
////        ngay = days - 30;
//        return ngay;
//    }

    public void ThemPhieuTra(ActionEvent evt) throws SQLException {
        int id = Integer.parseInt(txtid.getText());

        List<PhieuMuon> dspm = s.getPhieuMuonByid_DocGia(id);
        List<PhieuMuonChiTiet> dspmct = pmcts.getPhieuMuonCTByIDPM(dspm.get(0).getId());

//        CheckTienPhat();

        if (dspmct.size() != 0) {

            for (PhieuMuonChiTiet pmct : dspmct) {

                int result = pmct.getTen().compareTo(txtTenSach.getText());
                if (result == 0) {

                    int slm = Integer.parseInt(pmct.getSL());
                    int slt = Integer.parseInt(txtSoLuong.getText());

                    if (slm > slt) {
                        slm = slm - slt;
                        String st = Integer.toString(slm);
                        try {
                            PhieuTra pt = new PhieuTra(txtTenSach.getText(), txtSoLuong.getText(), dateNgayMuon.getValue(), pmct.getId(), 0);
                            pmct.setSLCT(st);

                            pts.themPhieuTra(pt);
                            pmcts.SuaPMCT(pmct);

                            loadData(txtid.getText());
                            txtTenSach.setText("");
                            txtSoLuong.setText("");
                            MessageBox.getBox("Thông báo", "Thêm thành công!!", Alert.AlertType.INFORMATION).show();

                        } catch (SQLException ex) {
                            MessageBox.getBox("Thông báo", "Thêm thất bại", Alert.AlertType.ERROR).show();
                            Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    if (slm == slt) {
                        PhieuTra pt = new PhieuTra(txtTenSach.getText(), txtSoLuong.getText(), dateNgayMuon.getValue(), pmct.getId(), 5000);

                        pmct.setSLCT("0");
                        pmct.setTrangThai(1);
                        try {
                            pts.themPhieuTra(pt);
                            pmcts.SuaPMCT(pmct);

                            loadData(txtid.getText());
                            txtTenSach.setText("");
                            txtSoLuong.setText("");
                            MessageBox.getBox("Thông báo", "Thêm thành công!!", Alert.AlertType.INFORMATION).show();

                            List<PhieuMuonChiTiet> dspmcts = pmcts.getPhieuMuonCTByIDPM(dspm.get(0).getId());

                            if (dspmcts.size() == 0) {

                                dspm.get(0).setTrangThai(1);
                                s.SuaTrangThaiPM(dspm.get(0));

                                txtTen.setText("");
                                txtid.setText("");
                                break;
                            }
                        } catch (SQLException ex) {
                            MessageBox.getBox("Thông báo", "Thêm thất bại", Alert.AlertType.ERROR).show();
                            Logger.getLogger(PhieuMuonController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    } else {
                        MessageBox.getBox("Thông báo", "Số Lượng Không đúng", Alert.AlertType.ERROR).show();
                        break;
                    }
                } else {
                    MessageBox.getBox("Thông báo", "Tên sách sai!!", Alert.AlertType.ERROR).show();
                    break;
                }
            }
        } else {
            MessageBox.getBox("Thông báo", "Chưa mượn sách hoặc đã trả hết", Alert.AlertType.ERROR).show();
        }
    }

    public void SuaPhieuMuon(ActionEvent evt) throws SQLException {

        int id = Integer.parseInt(txtid.getText());
        List<PhieuMuon> dspm = s.getPhieuMuonByid_DocGia(id);
        List<PhieuMuonChiTiet> dspmct = pmcts.getPhieuMuonCTByIDPM(dspm.get(0).getId());

        if (dspmct.size() != 0) {
            MessageBox.getBox("Thông báo", "Chưa trả hết sách đã mượn!", Alert.AlertType.INFORMATION).show();
        } else {
            MessageBox.getBox("Thông báo", "Đã trả hết sách đã mượn!", Alert.AlertType.INFORMATION).show();
        }
    }

    private void loadTableColumns() {
//        TableColumn colid = new TableColumn("id");
//        colid.setCellValueFactory(new PropertyValueFactory("id"));
//        colid.setPrefWidth(200);

        TableColumn colname = new TableColumn("Tên sách");
        colname.setCellValueFactory(new PropertyValueFactory("Ten"));
        colname.setPrefWidth(200);

        TableColumn colnm = new TableColumn("Số lượng chưa trả");
        colnm.setCellValueFactory(new PropertyValueFactory("SLCT"));
        colnm.setPrefWidth(200);

//        TableColumn colpm = new TableColumn(" Phiếu Mượn");
//        colpm.setCellValueFactory(new PropertyValueFactory("id_PhieuMuon"));
//        colpm.setPrefWidth(200);
        TableColumn colnt = new TableColumn("Trạng Thái");
        colnt.setCellValueFactory(new PropertyValueFactory("trangThai"));
        colnt.setPrefWidth(200);

        this.tbPhieuTra.getColumns().addAll(colname, colnm, colnt);
    }

    private void loadData(String kw) throws SQLException {
        int id = Integer.parseInt(kw);
        String idpm = s.getPhieuMuonByid_DocGia(id).get(0).getId();
        List<PhieuMuonChiTiet> k = pmcts.getPhieuMuonCTByIDPM(idpm);
        this.tbPhieuTra.setItems(FXCollections.observableList(k));
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

        
}
