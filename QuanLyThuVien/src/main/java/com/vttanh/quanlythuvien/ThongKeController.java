/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class ThongKeController implements Initializable {

    @FXML private PieChart bieudotron;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<PieChart.Data> PieChartData
            = FXCollections.observableArrayList(
                    new PieChart.Data("Điểm A", 50),
                    new PieChart.Data("Điểm B", 90),
                    new PieChart.Data("Điểm C", 300),
                    new PieChart.Data("Điểm D", 300));
            bieudotron.setData(PieChartData);
    }    
    
}
