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
public class DocGia {

    private int id;
    private String Ten;
    private String GT;
    private Date NgaySinh;
    private LocalDate NgaySinh1;
    private String Email;
    private String SDT;
    private String DiaChi;
    private int TrangThai;
    private Date NgayDangKi;
    private LocalDate NgayDangKi1;
    private int DoiTuong;
    private int BoPhan;
    
//    {
//        NgayDangKi = new Date() ;
//    }
    
    {
        NgayDangKi1 = LocalDate.now();
    }
    
    public DocGia(String Ten,Date NgaySinh, String GT, String Email, String SDT, String DiaChi, int DoiTuong , int BoPhan) {
        this.Ten = Ten;
        this.GT = GT;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.BoPhan = BoPhan;
        this.DoiTuong = DoiTuong;
    }
    
    public DocGia(String Ten, LocalDate NgaySinh1, String GT, String Email, String SDT, String DiaChi, int DoiTuong , int BoPhan) {
        this.Ten = Ten;
        this.GT = GT;
        this.NgaySinh1 = NgaySinh1;
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
    
    public DocGia(int id, String Ten, Date NgaySinh, String GT, String SDT, Date NgayDangKi) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.GT = GT;
        this.SDT = SDT;
        this.NgayDangKi = NgayDangKi;
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
    public Date getNgaySinh() {
        return NgaySinh;
    }

    /**
     * @param NgaySinh the NgaySinh to set
     */
    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    /**
     * @return the NgayDangKi
     */
    public Date getNgayDangKi() {
        return NgayDangKi;
    }

    /**
     * @param NgayDangKi the NgayDangKi to set
     */
    public void setNgayDangKi(Date NgayDangKi) {
        this.NgayDangKi = NgayDangKi;
    }

    /**
     * @return the NgaySinh1
     */
    public LocalDate getNgaySinh1() {
        return NgaySinh1;
    }

    /**
     * @param NgaySinh1 the NgaySinh1 to set
     */
    public void setNgaySinh1(LocalDate NgaySinh1) {
        this.NgaySinh1 = NgaySinh1;
    }

    /**
     * @return the NgayDangKi1
     */
    public LocalDate getNgayDangKi1() {
        return NgayDangKi1;
    }

    /**
     * @param NgayDangKi1 the NgayDangKi1 to set
     */
    public void setNgayDangKi1(LocalDate NgayDangKi1) {
        this.NgayDangKi1 = NgayDangKi1;
    }
    
    
}
