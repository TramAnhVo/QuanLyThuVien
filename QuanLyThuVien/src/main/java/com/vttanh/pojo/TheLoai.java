/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class TheLoai {

    private int id;
    private String Ten;

    public TheLoai(int id, String Ten) {
        this.id = id;
        this.Ten = Ten;
    }

    public TheLoai() {
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

    /**
     * @param Ten the Ten to set
     */
    public void setTen(String Ten) {
        this.Ten = Ten;
    }
   
    
}
