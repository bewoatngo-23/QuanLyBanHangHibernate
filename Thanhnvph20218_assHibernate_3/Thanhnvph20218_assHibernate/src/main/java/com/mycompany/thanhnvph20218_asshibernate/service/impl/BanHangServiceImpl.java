/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service.impl;

import com.mycompany.thanhnvph20218_asshibernate.repository.impl.BanHangRepository;
import com.mycompany.thanhnvph20218_asshibernate.service.IBanHangService;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.GioHangModel;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangServiceImpl implements IBanHangService{
    private BanHangRepository banHangRes = new BanHangRepository();
    @Override
    public List<SanPhamViewModel> getAll() {
        return banHangRes.getAll();
    }

    @Override
    public List<GioHangModel> getAllId(String id) {
        return banHangRes.getAllId(id);
    }
    
}
