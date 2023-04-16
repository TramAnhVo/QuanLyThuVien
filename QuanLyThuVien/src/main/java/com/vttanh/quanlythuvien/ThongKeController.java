/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vttanh.quanlythuvien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Trâm Anh
 */
public class ThongKeController implements Initializable {

    @FXML private PieChart bieudotron;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        StackPane pane = new StackPane();
//        PieChart c = new PieChart();
//        c.setLabelLineLength(25);
//        c.setLegendSide(Side.LEFT);
//        c.getData().add(new PieChart.Data("Điếm A", 50));
//        c.getData().add(new PieChart.Data("Điếm B", 90));
//        c.getData().add(new PieChart.Data("Điếm C", 300));
//        c.getData().add(new PieChart.Data("Điếm D", 500));
//        pane.getChildren().add(c);

        ObservableList<PieChart.Data> PieChartData
            = FXCollections.observableArrayList(
                    new PieChart.Data("Điểm A", 50),
                    new PieChart.Data("Điểm B", 90),
                    new PieChart.Data("Điểm C", 300),
                    new PieChart.Data("Điểm D", 300));
            bieudotron.setData(PieChartData);
    }    
    
}
