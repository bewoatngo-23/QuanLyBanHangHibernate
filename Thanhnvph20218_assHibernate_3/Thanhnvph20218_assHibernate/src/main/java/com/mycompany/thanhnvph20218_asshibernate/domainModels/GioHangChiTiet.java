/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.math.BigDecimal;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@ToString
public class GioHangChiTiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "Id")
    private ChiTietSanPham chiTietSP;

    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam", nullable = false)
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang gioHang, ChiTietSanPham chiTietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public Object[] todataRow() {
        return new Object[]{gioHang.getId(), chiTietSP.getId(), soLuong, donGia, donGiaKhiGiam};
    }
}
