/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.math.BigDecimal;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@ToString
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon" ,referencedColumnName = "Id")
    private HoaDon hoaDon;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP" ,referencedColumnName = "Id")
    private ChiTietSanPham chiTietSP;

    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSanPham chiTietSP, int soLuong, BigDecimal donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Object[] todataRow() {
        return new Object[]{hoaDon.getId(), chiTietSP.getId(), soLuong, donGia};
    }
}
