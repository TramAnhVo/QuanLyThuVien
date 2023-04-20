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
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class ThongKeController implements Initializable {

   
         @FXML
    private PieChart bieudotron;
    @FXML
    private ComboBox<String> cbbThang;

    PhieuTraService pt = new PhieuTraService();
    PhieuMuonChiTietService pmct = new PhieuMuonChiTietService();
    MuonService s = new MuonService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbbThang.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        
         this.cbbThang.itemsProperty().addListener(d -> {
             
            try {
                getSoLuongPhieuMuonCT();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                getSoLuongPhieuTra();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
         
        try {
            int pm = getSoLuongPhieuMuonCT();
            int pt = getSoLuongPhieuTra();
            
            ObservableList<PieChart.Data> PieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Số Sách Mượn", pm),
                    new PieChart.Data("Số Sách", 30),
                    new PieChart.Data("Số Sách Trả", pt));
            bieudotron.setData(PieChartData);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSoLuongPhieuTra() throws SQLException {
        int sl = 0;
        List<PhieuTra> dspt = pt.getSLPhieuTra();
        for (PhieuTra p : dspt) {
            Date date = p.getNgayTra1();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1;

            int thang = cbbThang.getSelectionModel().getSelectedIndex() + 1;
            if (month == thang) {
                int s = Integer.parseInt(p.getSL());
                sl = sl + s;

            } else {
                int s = Integer.parseInt(p.getSL());
                sl = sl + s;
            }
        }

        return sl;
    }

    public int getSoLuongPhieuMuonCT() throws SQLException {
        int sl = 0;
        List<PhieuMuon> dspm = s.getNgayMuon();
        for (PhieuMuon pm : dspm) {

            Date date = pm.getNgayMuon1();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1;

            int thang = cbbThang.getSelectionModel().getSelectedIndex() + 1;

            if (month == thang) {
                List<PhieuMuonChiTiet> dspmct = pmct.getSLPhieuMuonCT(pm.getId());
                for (PhieuMuonChiTiet pmct : dspmct) {
                    int s = Integer.parseInt(pmct.getSL());
                    sl = sl + s;
                }

            } else {
                List<PhieuMuonChiTiet> dspmct = pmct.getSLPhieuMuonCT(pm.getId());
                for (PhieuMuonChiTiet pmct : dspmct) {
                    int s = Integer.parseInt(pmct.getSL());
                    sl = sl + s;
                }
            }
        }
//        List<PhieuMuonChiTiet> dspt = pmct.getSLPhieuMuonCT();
//        for (PhieuMuonChiTiet p : dspt) {
//            int s = Integer.parseInt(p.getSL());
//            sl = sl + s;
//        }

        return sl;
    }
}
