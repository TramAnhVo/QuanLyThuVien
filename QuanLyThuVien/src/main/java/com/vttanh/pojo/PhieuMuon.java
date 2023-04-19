/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Trâm Anh
 */
    public class PhieuMuon {
        private int id;
        private String Ten;
        private LocalDate NgayMuon;
        private Date NgayMuon1;
        private String SL;
        
    
        // nap thong tin len giao dien
        public PhieuMuon(int id, String Ten, String SDT, Date NgayMuon1, String SL) {
            this.id = id;
            this.Ten = Ten;
            this.NgayMuon1 = NgayMuon1;
        }
        
        // luu thong tin xuong csdl
        public PhieuMuon( String Ten, LocalDate NgayMuon) {
            this.Ten = Ten;
            this.NgayMuon = NgayMuon;
        }
                
        @Override
        public String toString() {
            return this.getTen();
        }
        
        public PhieuMuon(){
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
     * @return the NgayMuon
     */
    public LocalDate getNgayMuon() {
        return NgayMuon;
    }

    /**
     * @param NgayMuon the NgayMuon to set
     */
    public void setNgayMuon(LocalDate NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    /**
     * @return the NgayMuon1
     */
    public Date getNgayMuon1() {
        return NgayMuon1;
    }

    /**
     * @param NgayMuon1 the NgayMuon1 to set
     */
    public void setNgayMuon1(Date NgayMuon1) {
        this.NgayMuon1 = NgayMuon1;
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
