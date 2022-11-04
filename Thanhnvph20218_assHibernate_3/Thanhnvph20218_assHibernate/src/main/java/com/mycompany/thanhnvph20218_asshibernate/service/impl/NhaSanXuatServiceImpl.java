/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhaSanXuatCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhaSanXuat;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.MauSacRepository;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.NhaSanXuatRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.INhaSanXuatService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhaSanXuatServiceImpl implements INhaSanXuatService{

    private NhaSanXuatRepository NhaSanXuatRes = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> listAll = new ArrayList<>();
        return listAll = NhaSanXuatRes.getAll();
    }

    @Override
    public NhaSanXuat getOne(String ma) {
        return NhaSanXuatRes.getOne(ma);
    }

    @Override
    public String add(NhaSanXuat ms) {
        if (NhaSanXuatRes.add(ms)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(NhaSanXuat ms, String id) {
        if (NhaSanXuatRes.update(ms, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (NhaSanXuatRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<NhaSanXuatCustomModel> getAllCustom() {
        return NhaSanXuatRes.getAllCustomModel();
    }
}
