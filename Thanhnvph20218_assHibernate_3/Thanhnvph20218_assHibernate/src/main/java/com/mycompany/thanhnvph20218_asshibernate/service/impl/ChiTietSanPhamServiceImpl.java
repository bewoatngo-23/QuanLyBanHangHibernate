/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.ChiTietSanPhamRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IChiTietSanPhamService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel;
import com.mycompany.thanhnvph20218_asshibernate.customModels.ChiTietSanPhamCustomModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamServiceImpl implements IChiTietSanPhamService<ChiTietSanPham> {

    private ChiTietSanPhamRepository ChiTietSPRes = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> listAll = new ArrayList<>();
        return listAll = ChiTietSPRes.getAll();
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return ChiTietSPRes.getOne(id);
    }

    @Override
    public String add(ChiTietSanPham ctsp) {
        if (ChiTietSPRes.add(ctsp)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(ChiTietSanPham ctsp, String id) {
        if (ChiTietSPRes.update(ctsp, id)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String id) {
        if (ChiTietSPRes.delete(id)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<ChiTietSanPham> getAllTen(String ten) {
        return ChiTietSPRes.getAllTen(ten);
    }

    @Override
    public void updateSoLuong(ChiTietSanPham t, String id) {
        ChiTietSPRes.updateSoLuong(t, id);
    }

    public List<SanPhamViewModel> search(List<SanPhamViewModel> listChiTietSPs, String ten) {
        List<SanPhamViewModel> listSanPhamViewModel = new ArrayList<>();
        for (int i = 0; i < listChiTietSPs.size(); i++) {
            if (listChiTietSPs.get(i).getTenSP().contains(ten) || listChiTietSPs.get(i).getMaSP().contains(ten)) {
                listSanPhamViewModel.add(listChiTietSPs.get(i));
            }
        }
        return listSanPhamViewModel;
    }

    @Override
    public List<ChiTietSanPhamCustomModel> getAllCustom() {
        return ChiTietSPRes.getAllCustom();
    }
}
