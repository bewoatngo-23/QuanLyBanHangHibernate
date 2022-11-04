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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CuaHang")
@Getter
@Setter
@ToString
public class CuaHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @Column(name = "Ma", nullable = false, length = 20)
    private String ma;

    @Column(name = "Ten", nullable = false, length = 30)
    private String ten;

    @Column(name = "DiaChi", nullable = false, length = 100)
    private String diaChi;

    @Column(name = "ThanhPho", nullable = false, length = 50)
    private String thanhPho;

    @Column(name = "QuocGia", nullable = false, length = 50)
    private String quocGia;

    @OneToMany(mappedBy = "ch", fetch = FetchType.LAZY)
    List<NhanVien> nhanVien;

    public CuaHang(String id) {
        this.id = id;
    }

    public CuaHang(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public CuaHang() {
    }

    public CuaHang(String id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    public CuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public CuaHang(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia, List<NhanVien> nhanVien) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.nhanVien = nhanVien;
    }
    
    public Object[] todataRow() {
        return new Object[]{id, ma, ten, diaChi, thanhPho, quocGia};
    }
}
