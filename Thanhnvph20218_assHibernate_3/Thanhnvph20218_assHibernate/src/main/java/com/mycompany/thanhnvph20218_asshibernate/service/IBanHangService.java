/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.GioHangModel;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IBanHangService {

    List<SanPhamViewModel> getAll();
    
     List<GioHangModel> getAllId(String id);
}
