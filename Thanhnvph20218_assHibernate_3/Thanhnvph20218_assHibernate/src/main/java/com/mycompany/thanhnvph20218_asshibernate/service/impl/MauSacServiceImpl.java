/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.MauSacCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.MauSacRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IMauSacService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MauSacServiceImpl implements IMauSacService{

    private MauSacRepository MauSacRes = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        List<MauSac> listAll = new ArrayList<>();
        return listAll = MauSacRes.getAll();
    }

    @Override
    public MauSac getOne(String ma) {
        return MauSacRes.getOne(ma);
    }

    @Override
    public String add(MauSac ms) {
        if (MauSacRes.add(ms)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(MauSac ms, String id) {
        if (MauSacRes.update(ms, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (MauSacRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<MauSacCustomModel> getAllCustom() {
        return MauSacRes.getAllCustomModel();
    }
}
