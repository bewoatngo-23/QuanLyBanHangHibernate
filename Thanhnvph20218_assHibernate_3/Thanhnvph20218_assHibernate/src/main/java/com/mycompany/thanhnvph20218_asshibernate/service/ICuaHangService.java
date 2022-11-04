/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.CuaHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.CuaHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(String ma);

    String add(CuaHang t);

    String update(CuaHang t, String id);

    String delete(String ma);

    List<CuaHangCustomModel> getAllCustom();
}
