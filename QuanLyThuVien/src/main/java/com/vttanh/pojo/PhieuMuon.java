/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Trâm Anh
 */
    public class PhieuMuon {
        private String id;
        private String Ten;
        private LocalDate NgayMuon;
        private Date NgayMuon1;
        private int trangThai;
        private int id_DocGia;
        
        {
            LocalDate ngay = LocalDate.now(); 
            setNgayMuon(ngay);
            String s = (UUID.randomUUID().toString());
            id = s.substring(0, 10);
        }
        
           public PhieuMuon( String id, Date NgayMuon) {
               this.id=id;
            this.NgayMuon1 = NgayMuon;
      
        }
        
        // lay xuong csdl
        public PhieuMuon( String Ten, LocalDate NgayMuon, int trangThai, int id_DocGia) {
            this.Ten = Ten;
            this.NgayMuon = NgayMuon;
            this.trangThai = trangThai;
            this.id_DocGia = id_DocGia;
        }
        
        // lay len giao dien
         public PhieuMuon( String Ten, Date NgayMuon1, int trangThai) {
            this.Ten = Ten;
            this.NgayMuon1 = NgayMuon1;
            this.trangThai = trangThai;
        }
 
        public PhieuMuon(String id, String Ten, Date NgayMuon1, int trangThai, int id_DocGia) {
            this.id = id;
            this.Ten = Ten;
            this.NgayMuon1 = NgayMuon1;
            this.trangThai = trangThai;
            this.id_DocGia = id_DocGia;
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
     * @return the id_DocGia
     */
    public int getId_DocGia() {
        return id_DocGia;
    }

    /**
     * @param id_DocGia the id_DocGia to set
     */
    public void setId_DocGia(int id_DocGia) {
        this.id_DocGia = id_DocGia;
    }  
}
