/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhanVienCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhanVien;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.KhachHangRepository;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.NhanVienRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.INhanVienService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements INhanVienService {

    private NhanVienRepository NhanVienRes = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> listAll = new ArrayList<>();
        return listAll = NhanVienRes.getAll();
    }

    @Override
    public NhanVien getOne(String ma) {
        NhanVien nv = NhanVienRes.getOne(ma);
        return nv;
    }

    @Override
    public String add(NhanVien nv) {
        if (NhanVienRes.add(nv)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(NhanVien nv, String ma) {
        if (NhanVienRes.update(nv, ma)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String ma) {
        if (NhanVienRes.delete(ma)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<NhanVienCustomModel> getAllCustom() {
        return NhanVienRes.getAllCustomModel();
    }
}
