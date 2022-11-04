/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

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
@Table(name = "NhanVien")
@Getter
@Setter
@ToString
public class NhanVien implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @Column(name = "Ma", nullable = false, length = 20)
    private String ma;

    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @Column(name = "TenDem", length = 30, nullable = false)
    private String tenDem;

    @Column(name = "Ho", length = 30, nullable = false)
    private String ho;

    @Column(name = "GioiTinh", length = 10, nullable = false)
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;

    @Column(name = "Sdt", length = 30, nullable = false)
    private String sdt;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang ch;

    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu cv;

    @Column(name ="IdGuiBC")
    private NhanVien nv;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String id) {
        this.id = id;
    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang ch, ChucVu cv, NhanVien nv, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.ch = ch;
        this.cv = cv;
        this.nv = nv;
        this.trangThai = trangThai;
    }

    public NhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang ch, ChucVu cv,NhanVien nv, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.ch = ch;
        this.cv = cv;
        this.trangThai = trangThai;
    }

    public Object[] todataRow() {
        return new Object[]{cv.getTen(),ch.getTen(), ma, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai, ngaySinh};
    }
}
