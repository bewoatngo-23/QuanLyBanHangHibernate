/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@ToString
public class ChiTietSanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> HoaDonChiTiet;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> GioHangChiTiet;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id) {
        this.id = id;
    }

    public ChiTietSanPham(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public ChiTietSanPham(String id, SanPham sanPham, NhaSanXuat nhaSanXuat, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongLon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongLon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(SanPham sanPham, NhaSanXuat nhaSanXuat, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
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

    public Object[] toDataRow() {
        return new Object[]{sanPham.getMa(), mauSac.getMa(), dongSP.getMa(), nhaSanXuat.getMa(), namBH, moTa, soLuongTon, giaNhap, giaBan};
    }
}
