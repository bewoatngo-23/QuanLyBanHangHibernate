/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonChiTietCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDonChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.HoaDonChiTietRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IHoaDonChiTietService;
import com.mycompany.thanhnvph20218_asshibernate.service.IHoaDonGioHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietServiceImpl implements IHoaDonChiTietService<HoaDonChiTiet> {

    private HoaDonChiTietRepository HoaDonCTRes = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> listAll = new ArrayList<>();
        return listAll = HoaDonCTRes.getAll();
    }

    @Override
    public HoaDonChiTiet getOne(String idHd, String idCtsp) {
        return HoaDonCTRes.getOne(idHd, idCtsp);
    }

    @Override
    public String add(HoaDonChiTiet hdct) {
        if (HoaDonCTRes.add(hdct)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(HoaDonChiTiet hdct, String idHd, String idCtsp) {
        if (HoaDonCTRes.update(hdct, idHd, idCtsp)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String idHd, String idCtsp) {
        if (HoaDonCTRes.delete(idHd, idCtsp)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<HoaDonChiTiet> getOneHoaDonCT(String id1) {
        return HoaDonCTRes.getAllHoaDonCT(id1);
    }

    @Override
    public List<HoaDonChiTietCustomModel> getAllCustom() {
        return HoaDonCTRes.getAllCustom();
    }

}
