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
public class HoaDonChiTietCustomModel {

    private String idHd;
    private String idCtsp;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTietCustomModel() {
    }

    public HoaDonChiTietCustomModel(String idHd, String idCtsp, int soLuong, BigDecimal donGia) {
        this.idHd = idHd;
        this.idCtsp = idCtsp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }


    public String getIdHd() {
        return idHd;
    }

    public void setIdHd(String idHd) {
        this.idHd = idHd;
    }

    public String getIdCtsp() {
        return idCtsp;
    }

    public void setIdCtsp(String idCtsp) {
        this.idCtsp = idCtsp;
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

    @Override
    public String toString() {
        return "HoaDonChiTietCustomModel{" + "idHd=" + idHd + ", idCtsp=" + idCtsp + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    public Object[]todataRow(){
        return new Object[]{idHd,idCtsp,soLuong,donGia};
        }
}
