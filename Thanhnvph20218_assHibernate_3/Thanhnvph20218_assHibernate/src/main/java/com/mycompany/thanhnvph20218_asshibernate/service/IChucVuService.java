/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.ChucVuCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChucVu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(String ma);

    String add(ChucVu t);

    String update(ChucVu t, String id);

    String delete(String ma);

    List<ChucVuCustomModel> getAllCustom();
}
