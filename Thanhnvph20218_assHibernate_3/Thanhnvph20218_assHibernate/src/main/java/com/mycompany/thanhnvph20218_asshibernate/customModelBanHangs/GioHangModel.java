/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class GioHangModel {

    private String idCtsp;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private BigDecimal donGia;

    public GioHangModel() {
    }

    public GioHangModel(String idCtsp, String maSP, String tenSP, int soLuong, BigDecimal donGia) {
        this.idCtsp = idCtsp;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public GioHangModel(String maSP, String tenSP, int soLuong, BigDecimal donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdCtsp() {
        return idCtsp;
    }

    public void setIdCtsp(String idCtsp) {
        this.idCtsp = idCtsp;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }


    public BigDecimal tongTien(int soLuong, BigDecimal donGia) {
        BigDecimal tongTien1 = BigDecimal.ZERO;
        BigDecimal tongTien2 = BigDecimal.ZERO;
        tongTien1 = donGia.multiply(BigDecimal.valueOf(soLuong));
        tongTien2 = tongTien2.add(tongTien1);
        return tongTien2;
    }

    @Override
    public String toString() {
        return "GioHangModel{" + "idCtsp=" + idCtsp + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public Object[] todataRow(int i) {
        return new Object[]{i, maSP, tenSP, soLuong, donGia, tongTien(soLuong, donGia)};
    }
}
