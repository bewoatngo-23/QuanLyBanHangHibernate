/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.DongSPCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.DongSP;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDongSPService {

    List<DongSP> getAll();

    DongSP getOne(String ma);

    String add(DongSP t);

    String update(DongSP t, String id);

    String delete(String ma);

    List<DongSPCustomModel> getAllCustom();
}
