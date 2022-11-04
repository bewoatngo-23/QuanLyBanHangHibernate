/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHangChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.GioHangChiTietRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IHoaDonGioHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GioHangChiTietServiceImpl implements IHoaDonGioHangService<GioHangChiTiet> {

    private GioHangChiTietRepository HoaDonCTRes = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTiet> getAll() {
        List<GioHangChiTiet> listAll = new ArrayList<>();
        return listAll = HoaDonCTRes.getAll();
    }

    @Override
    public GioHangChiTiet getOne(String idGh, String idCtsp) {
        return HoaDonCTRes.getOne(idGh, idCtsp);
    }

    @Override
    public String add(GioHangChiTiet ghct) {
        if (HoaDonCTRes.add(ghct)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(GioHangChiTiet ghct, String idGh, String idCtsp) {
        if (HoaDonCTRes.update(ghct, idGh, idCtsp)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String idgh, String idCtsp) {
        if (HoaDonCTRes.delete(idgh, idCtsp)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<GioHangChiTiet> getOneHoaDonCT(String id1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
