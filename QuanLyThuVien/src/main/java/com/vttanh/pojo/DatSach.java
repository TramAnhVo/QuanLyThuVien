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
public class DatSach {
    private int id;
    private String Ten;
    private int GT;
    private String SDT;
    private String Email;
    private Date NgayDat;
    private LocalDate NgayDat1;
    private String SL;
    
    // luu thong tin duoi csdl
    public DatSach(String Ten, int GT, String SDT, String Email, LocalDate NgayDat1, String SL) {
        this.Ten = Ten;
        this.GT = GT;
        this.SDT = SDT;
        this.Email = Email;
        this.NgayDat1 = NgayDat1;
        this.SL = SL;       
    }
    
    // nap du lieu len giao dien
    public DatSach(int id, String Ten, int GT, String SDT, String Email, Date NgayDat,String SL) {
        this.id = id;
        this.Ten = Ten;
        this.GT = GT;
        this.SDT = SDT;
        this.Email = Email;
        this.NgayDat = NgayDat;
        this.SL = SL;       
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
     * @return the GT
     */
    public int getGT() {
        return GT;
    }

    /**
     * @param GT the GT to set
     */
    public void setGT(int GT) {
        this.GT = GT;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the NgayDat
     */
    public Date getNgayDat() {
        return NgayDat;
    }

    /**
     * @param NgayDat the NgayDat to set
     */
    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    /**
     * @return the NgayDat1
     */
    public LocalDate getNgayDat1() {
        return NgayDat1;
    }

    /**
     * @param NgayDat1 the NgayDat1 to set
     */
    public void setNgayDat1(LocalDate NgayDat1) {
        this.NgayDat1 = NgayDat1;
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
    
}
