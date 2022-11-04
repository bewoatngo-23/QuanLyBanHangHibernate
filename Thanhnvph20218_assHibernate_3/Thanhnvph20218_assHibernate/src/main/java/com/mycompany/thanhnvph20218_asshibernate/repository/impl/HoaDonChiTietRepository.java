/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonChiTietCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDonChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.thanhnvph20218_asshibernate.repository.IHoaDonCTRes;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository implements IHoaDonCTRes<HoaDonChiTiet> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM HoaDonChiTiet";

    @Override
    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery(fromTable, HoaDonChiTiet.class);
        List<HoaDonChiTiet> listHoaDonChiTiets = query.getResultList();
        return listHoaDonChiTiets;
    }

    public List<HoaDonChiTietCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonChiTietCustomModel(A.id, C.id, B.soLuong,B.donGia)"
                + " FROM HoaDon A INNER JOIN HoaDonChiTiet B ON A.id = B.hoaDon INNER JOIN ChiTietSanPham C ON B.chiTietSP = C.id";
        Query query = session.createQuery(hql);
        List<HoaDonChiTietCustomModel> listHoaDonChiTiets = query.getResultList();
        return listHoaDonChiTiets;
    }

    @Override
    public HoaDonChiTiet getOne(String idHd, String idCtsp) {
        HoaDonChiTiet hdct;
        String hql = fromTable + " where IdHoaDon = : idHoaDonUpdate and IdChiTietSP = : idChiTietSPUpdate";
        Query query = session.createQuery(hql, HoaDonChiTiet.class);
        query.setParameter("idHoaDonUpdate", idHd);
        query.setParameter("idChiTietSPUpdate", idCtsp);
        hdct = (HoaDonChiTiet) query.getSingleResult();
        return hdct;
    }

    @Override
    public boolean add(HoaDonChiTiet t) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(t);
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean update(HoaDonChiTiet t, String idHd, String idCtsp) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE HoaDonChiTiet set IdHoaDon = : idHoaDonUpdate,"
                        + "IdChiTietSP = : idChiTietSPUpdate, SoLuong = : soLuongUpdate, "
                        + "DonGia =: donGiaUpdate where IdHoaDon = : idHoaDon and IdChiTietSP = : idChiTietSP ");
                query.setParameter("idHoaDonUpdate", t.getHoaDon().getId());
                query.setParameter("idChiTietSPUpdate", t.getChiTietSP().getId());
                query.setParameter("soLuongUpdate", t.getSoLuong());
                query.setParameter("donGiaUpdate", t.getDonGia());
                query.setParameter("idHoaDon", idHd);
                query.setParameter("idChiTietSP", idCtsp);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public boolean delete(String idHd, String idCtsp) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM HoaDonChiTiet where IdHoaDon = : idHoaDon and IdChiTietSP = : idChiTietSP  ");
                query.setParameter("idHoaDon", idHd);
                query.setParameter("idChiTietSP", idCtsp);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
            }
        } finally {
            return check > 0;
        }
    }
    public static void main(String[] args) {
         List<HoaDonChiTietCustomModel> listSp = new HoaDonChiTietRepository().getAllCustom();
        for (HoaDonChiTietCustomModel sanPhamCustomModel : listSp) {
            System.out.println(sanPhamCustomModel.toString());
        }
    }

    @Override
    public List<HoaDonChiTiet> getAllHoaDonCT(String idHd) {
        String hql = "FROM HoaDonChiTiet where IdHoaDon =: idHoaDons";
        Query query = session.createQuery(hql, HoaDonChiTiet.class);
        query.setParameter("idHoaDons", idHd);
        List<HoaDonChiTiet> listHoaDonChiTiets = query.getResultList();
        return listHoaDonChiTiets;
    }
}
