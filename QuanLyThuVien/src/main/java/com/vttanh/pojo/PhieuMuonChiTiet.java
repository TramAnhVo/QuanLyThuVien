/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class PhieuMuonChiTiet {
    private int id;
    private String Ten;
    private String SL;
    private int id_PhieuMuon;
    
    public PhieuMuonChiTiet(String Ten, String SL, int id_PhieuMuon) {
        this.Ten = Ten;
        this.SL = SL;
        this.id_PhieuMuon = id_PhieuMuon;
    }
    
    public PhieuMuonChiTiet(int id, String Ten, String SL, int id_PhieuMuon) {
        this.id = id;
        this.Ten = Ten;
        this.SL = SL;
        this.id_PhieuMuon = id_PhieuMuon;
    }
    
    public PhieuMuonChiTiet() {
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
    
    /**
     * @return the SL
     */
    public String getSL() {
        return SL;
    }

    /**
     * @param SL the SL to set
     */
    public void setSL(String SL) {
        this.SL = SL;
    }

    /**
     * @return the id_PhieuMuon
     */
    public int getId_PhieuMuon() {
        return id_PhieuMuon;
    }

    /**
     * @param id_PhieuMuon the id_PhieuMuon to set
     */
    public void setId_PhieuMuon(int id_PhieuMuon) {
        this.id_PhieuMuon = id_PhieuMuon;
    }

    
    
    
}
