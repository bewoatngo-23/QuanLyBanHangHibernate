/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.ChucVuCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChucVu;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.ChucVuRepository;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.MauSacRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IChucVuService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChucVuServiceImpl implements IChucVuService {

    private ChucVuRepository ChucVuRes = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listAll = new ArrayList<>();
        return listAll = ChucVuRes.getAll();
    }

    @Override
    public ChucVu getOne(String ma) {
        return ChucVuRes.getOne(ma);
    }

    @Override
    public String add(ChucVu ms) {
        if (ChucVuRes.add(ms)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(ChucVu ms, String id) {
        if (ChucVuRes.update(ms, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (ChucVuRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<ChucVuCustomModel> getAllCustom() {
        return ChucVuRes.getAllCustom();
    }
}
