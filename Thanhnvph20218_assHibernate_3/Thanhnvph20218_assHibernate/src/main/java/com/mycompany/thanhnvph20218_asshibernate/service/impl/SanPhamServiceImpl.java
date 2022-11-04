/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.SanPhamCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.SanPhamRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.ISanPhamService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SanPhamServiceImpl implements ISanPhamService {

    private SanPhamRepository SanPhamRes = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        List<SanPham> listAll = new ArrayList<>();
        return listAll = SanPhamRes.getAll();
    }

    @Override
    public SanPham getOne(String ma) {
        return SanPhamRes.getOne(ma);
    }

    @Override
    public boolean add(SanPham sp) {
        boolean check = false;
        if (SanPhamRes.getOne(sp.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Mã trùng");
            return check;
        } else if (SanPhamRes.add(sp)) {
            JOptionPane.showMessageDialog(null, "Thành công");
            check = true;
            return check;
        } else {
            return check;
        }
    }

    @Override
    public String update(SanPham sp, String id) {
        if (SanPhamRes.update(sp, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (SanPhamRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<SanPhamCustomModel> getAllCustom() {
        return SanPhamRes.getAllCustom();
    }
}
