/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

import java.time.LocalDate;

/**
 *
 * @author Trâm Anh
 */
    public class PhieuMuon {
        private int id;
        private String Ten;
        private LocalDate NgayMuon;
        private String SDT;
        private String SL;

        public PhieuMuon(String Ten, LocalDate NgayMuon, String SDT, String SL) {
            this.Ten = Ten;
            this.NgayMuon = NgayMuon;
            this.SDT = SDT;
            this.SL = SL;
        }
        
        public PhieuMuon(int id, String Ten, LocalDate NgayMuon, String SDT, String SL) {
            this.id = id;
            this.Ten = Ten;
            this.NgayMuon = NgayMuon;
            this.SDT = SDT;
            this.SL = SL;
        }
        
        public PhieuMuon(int id, String Ten, String SDT, String SL) {
            this.id = id;
            this.Ten = Ten;
            this.SDT = SDT;
            this.SL = SL;
        }

        public PhieuMuon(){
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
}
