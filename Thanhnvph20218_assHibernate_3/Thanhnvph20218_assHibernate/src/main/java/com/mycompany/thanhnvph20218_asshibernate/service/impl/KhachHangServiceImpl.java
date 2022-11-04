/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.KhachHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.KhachHang;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.KhachHangRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IKhachHangService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements IKhachHangService {

    private KhachHangRepository KhachHangRes = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> listAll = new ArrayList<>();
        return listAll = KhachHangRes.getAll();
    }

    @Override
    public KhachHang getOne(String ma) {
        KhachHang kh = KhachHangRes.getOne(ma);
        return kh;
    }

    @Override
    public String add(KhachHang kh) {
        if (KhachHangRes.add(kh)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(KhachHang kh, String ma) {
        if (KhachHangRes.update(kh, ma)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String ma) {
        if (KhachHangRes.delete(ma)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<KhachHangCustomModel> getAllCustom() {
        return KhachHangRes.getAllCustom();
    }
}
