/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhaSanXuatCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhaSanXuat;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhaSanXuatService {

    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(String ma);

    String add(NhaSanXuat nsx);

    String update(NhaSanXuat nsx, String ma);

    String delete(String ma);
    
     List<NhaSanXuatCustomModel> getAllCustom();
}
