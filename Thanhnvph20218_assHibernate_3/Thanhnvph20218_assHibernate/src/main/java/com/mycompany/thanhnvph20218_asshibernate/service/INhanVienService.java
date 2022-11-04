/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhanVienCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhanVienService {

    List<NhanVien> getAll();

    NhanVien getOne(String ma);

    String add(NhanVien t);

    String update(NhanVien t, String id);

    String delete(String ma);

    List<NhanVienCustomModel> getAllCustom();
}
