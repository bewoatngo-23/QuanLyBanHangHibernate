/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.customModels;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamCustomModel {

    private String id;
    private String sanPham;
    private String nhaSanXuat;
    private String mauSac;
    private String dongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSanPhamCustomModel() {
    }

    public ChiTietSanPhamCustomModel(String id) {
        this.id = id;
    }

    public ChiTietSanPhamCustomModel(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public ChiTietSanPhamCustomModel(String id, String sanPham, String nhaSanXuat, String mauSac, String dongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPhamCustomModel(String id, String sanPham, String mauSac, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSanPhamCustomModel{" + "id=" + id + ", sanPham=" + sanPham + ", nhaSanXuat=" + nhaSanXuat + ", mauSac=" + mauSac + ", dongSP=" + dongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }
   public Object[] toDataRow() {
        return new Object[]{sanPham, mauSac, dongSP, nhaSanXuat, namBH, moTa, soLuongTon, giaNhap, giaBan};
    }
    
}
