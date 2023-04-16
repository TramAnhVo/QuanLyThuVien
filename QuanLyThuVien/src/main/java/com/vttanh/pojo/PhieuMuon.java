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
    public class PhieuMuon {
        private int id;
        private String Ten;
        private LocalDate NgayMuon;
        private Date NgayMuon1;
        private String SDT;
        private String SL;
        private int BoPhan;
        private int DoiTuong;

        public PhieuMuon(int id, String Ten, String SDT, Date NgayMuon1, String SL) {
            this.id = id;
            this.Ten = Ten;
            this.SDT = SDT;
            this.NgayMuon1 = NgayMuon1;
            this.SL = SL;
        }
        
        public PhieuMuon(int id, String Ten, String SDT, LocalDate NgayMuon, String SL) {
            this.id = id;
            this.Ten = Ten;
            this.SDT = SDT;
            this.NgayMuon = NgayMuon;
            this.SL = SL;
        }
                
        public PhieuMuon(String Ten, String SDT, LocalDate NgayMuon, String SL, int BoPhan, int DoiTuong) {
            this.Ten = Ten;
            this.SDT = SDT;
            this.NgayMuon = NgayMuon;
            this.SL = SL;
            this.BoPhan = BoPhan;
            this.DoiTuong = DoiTuong;
        }
        
        public PhieuMuon(int id, String Ten, String SDT, LocalDate NgayMuon, String SL, int BoPhan, int DoiTuong) {
            this.id = id;
            this.Ten = Ten;
            this.SDT = SDT;
            this.NgayMuon = NgayMuon;
            this.SL = SL;
            this.BoPhan = BoPhan;
            this.DoiTuong = DoiTuong;
        }
        
        public PhieuMuon(int id, String Ten){
            this.id = id ;
            this.Ten = Ten;
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
     * @return the DoiTuong
     */
    public int getDoiTuong() {
        return DoiTuong;
    }

    /**
     * @param DoiTuong the DoiTuong to set
     */
    public void setDoiTuong(int DoiTuong) {
        this.DoiTuong = DoiTuong;
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
     * @return the BoPhan
     */
    public int getBoPhan() {
        return BoPhan;
    }

    /**
     * @param BoPhan the BoPhan to set
     */
    public void setBoPhan(int BoPhan) {
        this.BoPhan = BoPhan;
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
