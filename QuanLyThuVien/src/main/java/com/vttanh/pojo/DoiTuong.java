/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class DoiTuong {

    private int id;
    private String Ten;

    public DoiTuong(int id, String Ten) {
        this.id = id;
        this.Ten = Ten;
    }

    public DoiTuong() {
    }

    @Override
    public String toString() {
        return this.Ten;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Ten
     */
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
}
