/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class TacGia {
    private int id;
    private String Tentg;

    public TacGia(int id, String Tentg) {
        this.id = id;
        this.Tentg = Tentg;
    }

    public TacGia() {
    }

    @Override
    public String toString() {
        return this.getTentg();}

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
     * @return the Tentg
     */
    public String getTentg() {
        return Tentg;
    }

    /**
     * @param Tentg the Tentg to set
     */
    public void setTentg(String Tentg) {
        this.Tentg = Tentg;
    }
}
