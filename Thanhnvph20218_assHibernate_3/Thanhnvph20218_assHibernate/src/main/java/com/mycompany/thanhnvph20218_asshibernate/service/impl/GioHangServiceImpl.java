/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHang;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.GioHangRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GioHangServiceImpl implements IServiceInterface<GioHang> {

    private GioHangRepository GioHangRes = new GioHangRepository();

    @Override
    public List<GioHang> getAll() {
        List<GioHang> listAll = new ArrayList<>();
        return listAll = GioHangRes.getAll();
    }

    @Override
    public GioHang getOne(String ma) {
        return GioHangRes.getOne(ma);
    }

    @Override
    public String add(GioHang gh) {
        if (GioHangRes.add(gh)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(GioHang gh, String ma) {
        if (GioHangRes.update(gh, ma)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String ma) {
        if (GioHangRes.delete(ma)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

}
