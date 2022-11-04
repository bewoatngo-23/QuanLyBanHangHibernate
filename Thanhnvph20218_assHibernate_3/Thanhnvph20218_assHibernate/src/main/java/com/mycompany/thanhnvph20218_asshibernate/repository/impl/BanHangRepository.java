/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.GioHangModel;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class BanHangRepository {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM ChiTietSanPham";

    public List<SanPhamViewModel> getAll() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel(A.id, B.ma, B.ten, A.namBH, A.moTa, A.soLuongTon, A.giaNhap, A.giaBan) "
                + "FROM ChiTietSanPham A JOIN SanPham B ON A.sanPham = B.id";
        Query query = session.createQuery(hql);
        List<SanPhamViewModel> listChiTietSP = query.getResultList();
        return listChiTietSP;
    }

    public List<GioHangModel> getAllId(String id) {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.GioHangModel(A.id, C.ma, C.ten, B.soLuong, B.donGia) "
                + "FROM ChiTietSanPham A INNER JOIN HoaDonChiTiet B ON A.id = B.chiTietSP "
                + "INNER JOIN SanPham C ON A.sanPham = C.id  where B.hoaDon.id = : idHihi";
        Query query = session.createQuery(hql);
        query.setParameter("idHihi", id);
        List<GioHangModel> listChiTietSP = query.getResultList();
        return listChiTietSP;
    }

//    public static void main(String[] args) {
//        List<SanPhamViewModel> listSp = new BanHangRepository().getAll();
//        for (SanPhamViewModel sanPhamCustomModel : listSp) {
//            System.out.println(sanPhamCustomModel.toString());
//        }
////        List<GioHangModel> listSp = new BanHangRepository().getAllId("HD6587");
////        for (GioHangModel gioHangCustomModel : listSp) {
////            System.out.println(gioHangCustomModel.toString());
////        }
//    }
}
