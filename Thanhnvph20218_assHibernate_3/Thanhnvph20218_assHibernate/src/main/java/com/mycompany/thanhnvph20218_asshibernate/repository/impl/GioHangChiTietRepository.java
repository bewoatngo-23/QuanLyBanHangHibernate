/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHangChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDonChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.thanhnvph20218_asshibernate.repository.IHoaDonCTRes;

/**
 *
 * @author Admin
 */
public class GioHangChiTietRepository implements IHoaDonCTRes<GioHangChiTiet> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM GioHangChiTiet";

    @Override
    public List<GioHangChiTiet> getAll() {
        Query query = session.createQuery(fromTable, GioHangChiTiet.class);
        List<GioHangChiTiet> listHoaDonChiTiets = query.getResultList();
        return listHoaDonChiTiets;
    }

    @Override
    public GioHangChiTiet getOne(String idHd, String idCtsp) {
        GioHangChiTiet hdct;
        String hql = fromTable + " where IdGioHang = : idGioHangUpdate and IdChiTietSP = : idChiTietSPUpdate";
        Query query = session.createQuery(hql, GioHangChiTiet.class);
        query.setParameter("idGioHangUpdate", idHd);
        query.setParameter("idChiTietSPUpdate", idCtsp);
        hdct = (GioHangChiTiet) query.getSingleResult();
        return hdct;
    }

    @Override
    public boolean add(GioHangChiTiet t) {
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
    public boolean update(GioHangChiTiet t, String idHd, String idCtsp) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE GioHangChiTiet set IdGioHang = : idGioHangUpdate,"
                        + "IdChiTietSP = : idChiTietSPUpdate, SoLuong = : soLuongUpdate, "
                        + "DonGia =: donGiaUpdate where IdGioHang = : idGioHang and IdChiTietSP = : idChiTietSP  ");
                query.setParameter("idGioHangUpdate", t.getGioHang().getId());
                query.setParameter("idChiTietSPUpdate", t.getChiTietSP().getId());
                query.setParameter("soLuongUpdate", t.getSoLuong());
                query.setParameter("donGiaUpdate", t.getDonGia());
                query.setParameter("idGioHang", idHd);
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
                Query query = session.createQuery("DELETE FROM GioHangChiTiet where IdGioHang = : idGioHang and IdChiTietSP = : idChiTietSP  ");
                query.setParameter("idGioHang", idHd);
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
    public List<GioHangChiTiet> getAllHoaDonCT(String idHd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
