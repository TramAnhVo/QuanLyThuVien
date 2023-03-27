/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.NguoiDoc;
import com.vttanh.services.ThongTin;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class DanhMucController implements Initializable {

    @FXML private TextField txtSearch;
    @FXML private TableView<NguoiDoc> tbNguoiDoc;
    @FXML private ComboBox<NguoiDoc> cbNguoiDoc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        demothongtin x = new demothongtin();
        try {
            
            this.loadTableColumns();
            this.loadTableData(null);
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    
    
    private void loadTableColumns() {       
        TableColumn colContent = new TableColumn("Họ Tên");
        colContent.setCellValueFactory(new PropertyValueFactory("Ten"));
        colContent.setPrefWidth(350);
        
        this.tbNguoiDoc.getColumns().addAll(colContent);
    }
    
     private void loadTableData(String kw) throws SQLException {
        demothongtin s = new demothongtin();
        List<NguoiDoc> q = s.DemoDocDL(kw);
        this.tbNguoiDoc.getItems().clear();
        this.tbNguoiDoc.setItems(FXCollections.observableList(q));
    }

   
}
