/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.pojo;

/**
 *
 * @author Trâm Anh
 */
public class Sach {
    private int id;
    private String Ten;
    private String MoTa;
    private String NXB;
    private String SoLuong;
    private int TheLoai;
    
    public Sach(String Ten, String MoTa, String NXB, String SoLuong, int TheLoai) {
        this.Ten = Ten;
        this.MoTa = MoTa;
        this.NXB = NXB;
        this.SoLuong = SoLuong;
        this.TheLoai = TheLoai;
    }
    
    public Sach(int id, String Ten, String MoTa, String NXB, String SoLuong) {
        this.id = id;
        this.Ten = Ten;
        this.MoTa = MoTa;
        this.NXB = NXB;
        this.SoLuong = SoLuong;
    }
    
    public Sach() {
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
     * @return the MoTa
     */
    public String getMoTa() {
        return MoTa;
    }

    /**
     * @param MoTa the MoTa to set
     */
    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    /**
     * @return the NXB
     */
    public String getNXB() {
        return NXB;
    }

    /**
     * @param NXB the NXB to set
     */
    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    /**
     * @return the SoLuong
     */
    public String getSoLuong() {
        return SoLuong;
    }

    /**
     * @param SoLuong the SoLuong to set
     */
    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }    

    /**
     * @return the TheLoai
     */
    public int getTheLoai() {
        return TheLoai;
    }

    /**
     * @param TheLoai the TheLoai to set
     */
    public void setTheLoai(int TheLoai) {
        this.TheLoai = TheLoai;
    }

        
}
