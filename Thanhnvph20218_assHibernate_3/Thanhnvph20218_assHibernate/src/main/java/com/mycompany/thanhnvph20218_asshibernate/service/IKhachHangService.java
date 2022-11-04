/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.KhachHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.KhachHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(String ma);

    String add(KhachHang t);

    String update(KhachHang t, String id);

    String delete(String ma);

    List<KhachHangCustomModel> getAllCustom();
}
