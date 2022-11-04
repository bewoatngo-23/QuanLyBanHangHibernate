/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.DongSPCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.DongSP;
import com.mycompany.thanhnvph20218_asshibernate.repository.impl.DongSPRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IDongSPService;
import com.mycompany.thanhnvph20218_asshibernate.service.IServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DongSPServiceImpl implements IDongSPService {

    private DongSPRepository DongSPRes = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        List<DongSP> listAll = new ArrayList<>();
        return listAll = DongSPRes.getAll();
    }

    @Override
    public DongSP getOne(String ma) {
        return DongSPRes.getOne(ma);
    }

    @Override
    public String add(DongSP sp) {
        if (DongSPRes.add(sp)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(DongSP sp, String id) {
        if (DongSPRes.update(sp, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (DongSPRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<DongSPCustomModel> getAllCustom() {
        return DongSPRes.getAllCustom();
    }
}
