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
public class DocGia {

    private int id;
    private String Ten;
    private String GT;
    private LocalDate NgaySinh;
    private String Email;
    private String SDT;
    private String DiaChi;
    private int TrangThai;
    private LocalDate NgayDangKi;
    private int DoiTuong;
    private int BoPhan;
    
    {
        NgayDangKi = LocalDate.now();
    }

    public DocGia(String Ten,LocalDate NgaySinh, String GT, String Email, String SDT, String DiaChi, int DoiTuong , int BoPhan) {
        this.Ten = Ten;
        this.GT = GT;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.BoPhan = BoPhan;
        this.DoiTuong = DoiTuong;
    }
    
    public DocGia(int id, String Ten) {
        this.id = id;
        this.Ten = Ten;
    }
    
    public DocGia(int id,String Ten, String GT, String SDT) {
        this.id = id;
        this.Ten = Ten;
        this.GT = GT;
        this.SDT = SDT;
    }

    public DocGia() {
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
     * @return the DiaChi
     */
    public String getDiaChi() {
        return DiaChi;
    }

    /**
     * @param DiaChi the DiaChi to set
     */
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    /**
     * @return the TrangThai
     */
    public int getTrangThai() {
        return TrangThai;
    }

    /**
     * @param TrangThai the TrangThai to set
     */
    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
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
     * @return the GT
     */
    public String getGT() {
        return GT;
    }

    /**
     * @param GT the GT to set
     */
    public void setGT(String GT) {
        this.GT = GT;
    }

    /**
     * @return the NgaySinh
     */
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    /**
     * @param NgaySinh the NgaySinh to set
     */
    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    /**
     * @return the NgayDangKi
     */
    public LocalDate getNgayDangKi() {
        return NgayDangKi;
    }

    /**
     * @param NgayDangKi the NgayDangKi to set
     */
    public void setNgayDangKi(LocalDate NgayDangKi) {
        this.NgayDangKi = NgayDangKi;
    }
    
    
}
