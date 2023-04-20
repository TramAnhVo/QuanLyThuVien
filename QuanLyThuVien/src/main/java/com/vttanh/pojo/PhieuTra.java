/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Trâm Anh
 */
public class PhieuTra {
     private int id;
    private String Ten;
    private String SL;
    private LocalDate ngayTra;
    private Date ngayTra1;
    private String id_PhieuMuonct;
    private float tienPhat;

    {
        LocalDate ngay = LocalDate.now();
        setNgayTra(ngay);
    }

    public PhieuTra(String sl, Date ngaytra1) {
        this.SL = sl;
        this.ngayTra1 = ngaytra1;
    }

    public PhieuTra(int id, String ten, String sl, LocalDate ngayTra, String idPhieuMuonCT, float tienPhat) {
        this.id = id;
        this.Ten = ten;
        this.SL = sl;
        this.ngayTra = ngayTra;
        this.id_PhieuMuonct = idPhieuMuonCT;
        this.tienPhat = tienPhat;
    }

    public PhieuTra(String ten, String sl, LocalDate ngayTra, String idPhieuMuonCT, float tienPhat) {
        this.Ten = ten;
        this.SL = sl;
        this.ngayTra = ngayTra;
        this.id_PhieuMuonct = idPhieuMuonCT;
        this.tienPhat = tienPhat;
    }

    public PhieuTra(String ten, String sl, Date ngayTra, String idPhieuMuonCT, float tienPhat) {
        this.Ten = ten;
        this.SL = sl;
        this.ngayTra1 = ngayTra;
        this.id_PhieuMuonct = idPhieuMuonCT;
        this.tienPhat = tienPhat;
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
     * @return the ngayTra
     */
    public LocalDate getNgayTra() {
        return ngayTra;
    }

    /**
     * @param ngayTra the ngayTra to set
     */
    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    /**
     * @return the ngayTra1
     */
    public Date getNgayTra1() {
        return ngayTra1;
    }

    /**
     * @param ngayTra1 the ngayTra1 to set
     */
    public void setNgayTra1(Date ngayTra1) {
        this.ngayTra1 = ngayTra1;
    }

    /**
     * @return the id_PhieuMuonct
     */
    public String getId_PhieuMuonct() {
        return id_PhieuMuonct;
    }

    /**
     * @param id_PhieuMuonct the id_PhieuMuonct to set
     */
    public void setId_PhieuMuonct(String id_PhieuMuonct) {
        this.id_PhieuMuonct = id_PhieuMuonct;
    }

    /**
     * @return the tienPhat
     */
    public float getTienPhat() {
        return tienPhat;
    }

    /**
     * @param tienPhat the tienPhat to set
     */
    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }
}
