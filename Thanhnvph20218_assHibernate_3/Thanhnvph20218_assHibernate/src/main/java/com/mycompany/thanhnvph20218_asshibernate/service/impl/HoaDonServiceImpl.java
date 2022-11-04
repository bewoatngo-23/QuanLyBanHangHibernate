/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDon;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.HoaDonRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IHoaDonService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Admin
 */
public class HoaDonServiceImpl implements IHoaDonService<HoaDon> {

    private HoaDonRepository HoaDonRes = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> listAll = new ArrayList<>();
        return listAll = HoaDonRes.getAll();
    }

    @Override
    public HoaDon getOne(String id) {
        return HoaDonRes.getOne(id);
    }

    @Override
    public String add(HoaDon ctsp) {
        if (HoaDonRes.add(ctsp)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(HoaDon ctsp, String id) {
        if (HoaDonRes.update(ctsp, id)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String id) {
        if (HoaDonRes.delete(id)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<HoaDon> getAllTinhTrang(int tinhTrang) {
        return HoaDonRes.getAllByTinhTrang(tinhTrang);
    }

    @Override
    public HoaDon getOneMa(String ma) {
        return HoaDonRes.getOneMa(ma);
    }

    @Override
    public void updateTinhTrang(HoaDon t, String id) {
        HoaDonRes.updateTinhTrang(t, id);
    }

    @Override
    public List<HoaDonCustomModel> getAllCustom() {
        return HoaDonRes.getAllCustom();
    }
}
