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
@Table(name = "SanPham")
@Getter
@Setter
@ToString
public class SanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;

    @Column(name = "Ma", length = 20, nullable = false, unique = true)
    private String ma;

    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> ChiTietSanPham;

    public SanPham() {
    }

    public SanPham(String id, String ma, String ten, List<ChiTietSanPham> ChiTietSanPham) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ChiTietSanPham = ChiTietSanPham;
    }

    public SanPham(String id) {
        this.id = id;
    }

    public SanPham(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public Object[] todataRow() {
        return new Object[]{id, ma, ten};
    }
}
