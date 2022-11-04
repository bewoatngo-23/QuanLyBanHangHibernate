/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.CuaHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.CuaHang;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.CuaHangRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.ICuaHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CuaHangServiceImpl implements ICuaHangService {

    private CuaHangRepository CuaHangRes = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> listAll = new ArrayList<>();
        return listAll = CuaHangRes.getAll();
    }

    @Override
    public CuaHang getOne(String ma) {
        return CuaHangRes.getOne(ma);
    }

    @Override
    public String add(CuaHang ch) {
        if (CuaHangRes.add(ch)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(CuaHang ch, String id) {
        if (CuaHangRes.update(ch, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (CuaHangRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<CuaHangCustomModel> getAllCustom() {
        return CuaHangRes.getAllCustom();
    }
}
