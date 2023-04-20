/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

import java.util.UUID;

/**
 *
 * @author Trâm Anh
 */
public class PhieuMuonChiTiet {
     private String id;
    private String Ten;
    private String SL;
    private String SLCT;
    private String id_PhieuMuon;
    private int trangThai;
    private int id_Sach;

    {
        String s = (UUID.randomUUID().toString());
        id = s.substring(0, 10);
    }

    public PhieuMuonChiTiet(String SL) {
        this.SL = SL;
    }

    public PhieuMuonChiTiet(String Ten, String SL, String id_PhieuMuon, int trangthai) {
        this.Ten = Ten;
        this.SL = SL;
        this.id_PhieuMuon = id_PhieuMuon;
        this.trangThai = trangthai;
//        this.id_Sach = id_Sach;
    }

    public PhieuMuonChiTiet(String Ten, String SL, String SLCT, int trangthai, int id_sach) {
        this.Ten = Ten;
        this.SL = SL;
        this.SLCT = SLCT;
        this.trangThai = trangthai;
        this.id_Sach = id_sach;
    }

    public PhieuMuonChiTiet(String id, String Ten, String SL, String SLCT, String id_PhieuMuon, int trangthai, int id_sach) {
        this.id = id;
        this.Ten = Ten;
        this.SL = SL;
        this.SLCT = SLCT;
        this.id_PhieuMuon = id_PhieuMuon;
        this.trangThai = trangthai;
        this.id_Sach = id_Sach;
    }

    public PhieuMuonChiTiet() {
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
    public String getId_PhieuMuon() {
        return id_PhieuMuon;
    }

    /**
     * @param id_PhieuMuon the id_PhieuMuon to set
     */
    public void setId_PhieuMuon(String id_PhieuMuon) {
        this.id_PhieuMuon = id_PhieuMuon;
    }

    /**
     * @return the trangThai
     */
    public int getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the id_sach
     */
    public int getId_Sach() {
        return id_Sach;
    }

    /**
     * @param id_sach the id_Sach to set
     */
    public void setId_Sach(int id_Sach) {
        this.id_Sach = id_Sach;
    }

    /**
     * @return the SLCT
     */
    public String getSLCT() {
        return SLCT;
    }

    /**
     * @param SLCT the SLCT to set
     */
    public void setSLCT(String SLCT) {
        this.SLCT = SLCT;
    }
}
