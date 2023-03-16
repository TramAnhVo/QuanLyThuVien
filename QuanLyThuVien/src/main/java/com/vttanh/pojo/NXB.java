/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class NXB {
    
    private int id;
    private String Tennxb;

    public NXB(int id, String Tennxb) {
        this.id = id;
        this.Tennxb = Tennxb;
    }

    public NXB() {
    }

    @Override
    public String toString() {
        return this.getTennxb();}
    
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
     * @return the Tennxb
     */
    public String getTennxb() {
        return Tennxb;
    }

    /**
     * @param Tennxb the Tennxb to set
     */
    public void setTennxb(String Tennxb) {
        this.Tennxb = Tennxb;
    }
}
