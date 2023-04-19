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
    private int GT;
    private Date NgaySinh1;
    private LocalDate NgaySinh;
    private String Email;
    private String SDT;
    private String DiaChi;
    private Date NgayDangKi1;
    private Date HanThe1;
    private LocalDate NgayDangKi;
    private LocalDate HanThe;
    private int DoiTuong;
    private int BoPhan;

    {
        setNgayDangKi(LocalDate.now());
        setHanThe(getNgayDangKi().plusYears(1));        
    }
    
    // nap du lieu len giao dien
    public DocGia(String Ten, Date NgaySinh1, int GT, String Email, String SDT, String DiaChi, int DoiTuong, int BoPhan) {
        this.Ten = Ten;
        this.GT = GT;
        this.NgaySinh1 = NgaySinh1;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.BoPhan = BoPhan;
        this.DoiTuong = DoiTuong;
    }
    
    // lay du lieu xuong csdl
    public DocGia(String Ten, LocalDate NgaySinh, int GT, String Email, String SDT, String DiaChi, int DoiTuong, int BoPhan) {
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

    public DocGia(int id, String Ten, Date NgaySinh1, int GT,  String SDT,Date NgayDangKi1, Date HanThe1) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh1 = NgaySinh1;
        this.GT = GT;
        this.SDT = SDT;
        this.NgayDangKi1 = NgayDangKi1;
        this.HanThe1 = HanThe1;
    }

    public DocGia(int id, String Ten, Date NgaySinh1, String Email, String SDT, String DiaChi, Date NgayDangKi1, Date HanThe1 ) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh1 = NgaySinh1;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.NgayDangKi1 = NgayDangKi1;
        this.HanThe1 = HanThe1;
        
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
     * @return the HanThe
     */
    public LocalDate getHanThe() {
        return HanThe;
    }

    /**
     * @param HanThe the HanThe to set
     */
    public void setHanThe(LocalDate HanThe) {
        this.HanThe = HanThe;
    }

    /**
     * @return the NgaySinh1
     */
    public Date getNgaySinh1() {
        return NgaySinh1;
    }

    /**
     * @param NgaySinh1 the NgaySinh1 to set
     */
    public void setNgaySinh1(Date NgaySinh1) {
        this.NgaySinh1 = NgaySinh1;
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
     * @return the NgayDangKi1
     */
    public Date getNgayDangKi1() {
        return NgayDangKi1;
    }

    /**
     * @param NgayDangKi1 the NgayDangKi1 to set
     */
    public void setNgayDangKi1(Date NgayDangKi1) {
        this.NgayDangKi1 = NgayDangKi1;
    }

    /**
     * @return the HanThe1
     */
    public Date getHanThe1() {
        return HanThe1;
    }

    /**
     * @param HanThe1 the HanThe1 to set
     */
    public void setHanThe1(Date HanThe1) {
        this.HanThe1 = HanThe1;
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
