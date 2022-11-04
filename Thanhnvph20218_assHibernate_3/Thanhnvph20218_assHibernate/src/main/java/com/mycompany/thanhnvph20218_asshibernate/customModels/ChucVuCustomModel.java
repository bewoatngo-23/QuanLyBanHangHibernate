/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.customModels;

/**
 *
 * @author Admin
 */
public class ChucVuCustomModel {

    private String id;
    private String ma;
    private String ten;

    public ChucVuCustomModel() {
    }

    public ChucVuCustomModel(String id) {
        this.id = id;
    }

    public ChucVuCustomModel(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public ChucVuCustomModel(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public Object[] todataRow() {
        return new Object[]{id, ma, ten};
    }
}
