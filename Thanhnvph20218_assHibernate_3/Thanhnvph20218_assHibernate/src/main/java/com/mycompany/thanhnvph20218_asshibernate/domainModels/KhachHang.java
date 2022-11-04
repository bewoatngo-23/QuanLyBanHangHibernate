/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.domainModels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Date;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@ToString
public class KhachHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @Column(name = "Ma", length = 20, nullable = false)
    private String ma;

    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @Column(name = "TenDem", length = 30, nullable = false)
    private String tenDem;

    @Column(name = "Ho", length = 30, nullable = false)
    private String ho;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt", length = 30, nullable = false)
    private String sdt;

    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;

    @Column(name = "ThanhPho", length = 50, nullable = false)
    private String thanhPho;

    @Column(name = "QuocGia", length = 50, nullable = false)
    private String quocGia;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    List<GioHang> GioHang;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    List<HoaDon> HoaDon;

    public KhachHang() {
    }

    public KhachHang(String id) {
        this.id = id;
    }

    public KhachHang(String id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }

    public KhachHang(String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }

    public Object[] todataRow() {
        return new Object[]{id, ma, ten, ngaySinh, sdt, quocGia, matKhau};
    }
}
