/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModels.MauSacCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMauSacService {

    List<MauSac> getAll();

    MauSac getOne(String ma);

    String add(MauSac t);

    String update(MauSac t, String id);

    String delete(String ma);

    List<MauSacCustomModel> getAllCustom();
}
