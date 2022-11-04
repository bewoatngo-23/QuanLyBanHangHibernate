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
import org.hibernate.engine.jdbc.Size;


/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ChucVu")
@Getter
@Setter
@ToString
public class ChucVu implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = true)
    private String id;
    
    @Column(name = "Ma", length = 20, nullable = false, unique = true)
    private String ma;
    
    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    List<NhanVien> NhanVien;
    
    public ChucVu() {
    }

    public ChucVu(String id) {
        this.id = id;
    }

    public ChucVu(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public ChucVu(String id, String ma, String ten, List<NhanVien> NhanVien) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.NhanVien = NhanVien;
    }

    public Object[] todataRow(int i) {
        return new Object[]{i,id, ma, ten};
    }
}
