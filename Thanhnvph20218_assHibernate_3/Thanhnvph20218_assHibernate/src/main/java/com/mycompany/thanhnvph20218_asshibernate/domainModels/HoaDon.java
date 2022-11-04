/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.sql.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "HoaDon")
@Getter
@Setter
@ToString
public class HoaDon implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    @Column(name = "Ma", nullable = false, length = 20)
    private String ma;

    @Column(name = "NgayTao", nullable = false)
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang", nullable = false)
    private int tinhTrang;

    @Column(name = "TenNguoiNhan", length = 50)
    private String tenNguoiNhan;

    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> HoaDonChiTiet;

    public HoaDon() {
    }

    public HoaDon(String id) {
        this.id = id;
    }

    public HoaDon(NhanVien nhanVien, String ma, Date ngayTao, int tinhTrang) {
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String id, KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String trangThai() {
        if (getTinhTrang() == 0) {
            return "Đã hủy";
        } else if (getTinhTrang() == 1) {
            return "Chờ thanh toán";
        } else {
            return "Đã thanh toán";
        }
    }

    public Object[] todataRow() {
        return new Object[]{khachHang.getMa(), nhanVien.getMa(), ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, trangThai(), tenNguoiNhan, diaChi, sdt};
    }

    public Object[] todataRowHoaDon(int i) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new Object[]{i, ma, dateFormat.format(ngayTao), nhanVien.getTen(), trangThai()};
    }
}
