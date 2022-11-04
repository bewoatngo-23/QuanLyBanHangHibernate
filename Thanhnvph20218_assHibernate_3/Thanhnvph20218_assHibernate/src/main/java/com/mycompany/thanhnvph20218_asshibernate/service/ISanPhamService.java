/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.SanPhamCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISanPhamService {

    List<SanPham> getAll();

    SanPham getOne(String ma);

    boolean add(SanPham t);

    String update(SanPham t, String id);

    String delete(String ma);
    
    List<SanPhamCustomModel> getAllCustom();
}
