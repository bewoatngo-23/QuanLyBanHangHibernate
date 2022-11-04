/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.sql.Date;
import java.sql.Date;
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
@Table(name = "GioHang")
@Getter
@Setter
@ToString
public class GioHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    @Column(name = "Ma", length = 20, nullable = false)
    private String ma;

    @Column(name = "NgayTao", nullable = false)
    private Date ngayTao;

    @Column(name = "NgayThanhToan", nullable = false)
    private Date ngayThanhToan;

    @Column(name = "TenNguoiNhan", nullable = false, length = 50)
    private String tenNguoiNhan;

    @Column(name = "DiaChi", nullable = false, length = 100)
    private String diaChi;

    @Column(name = "Sdt", nullable = false, length = 100)
    private String sdt;

    @Column(name = "TinhTrang", nullable = false)
    private int tinhTrang;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> GioHangChiTiet;

    public GioHang() {
    }

    public GioHang(String id, KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, int tinhTrang) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }

    public GioHang(String id) {
        this.id = id;
    }

    public GioHang(KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, int tinhTrang) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }

    public Object[] todataRow() {
        return new Object[]{khachHang.getMa(), nhanVien.getMa(), ma, ngayTao, ngayThanhToan, tenNguoiNhan, diaChi, sdt, tinhTrang};
    }

}
