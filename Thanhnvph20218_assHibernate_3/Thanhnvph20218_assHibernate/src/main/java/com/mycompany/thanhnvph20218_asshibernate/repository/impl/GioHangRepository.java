/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHang;
import com.mycompany.thanhnvph20218_asshibernate.repository.IInterface;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class GioHangRepository implements IInterface<GioHang> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM GioHang";

    @Override
    public List<GioHang> getAll() {
        Query query = session.createQuery(fromTable, GioHang.class);
        List<GioHang> listGioHangs = query.getResultList();
        return listGioHangs;
    }

    @Override
    public GioHang getOne(String ma) {
        GioHang gh;
        String hql = fromTable + " where Id = :id";
        Query query = session.createQuery(hql, GioHang.class);
        query.setParameter("id", ma);
        gh = (GioHang) query.getSingleResult();
        return gh;
    }

    @Override
    public boolean add(GioHang t) {
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
    public boolean update(GioHang t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE GioHang SET IdKH = : idKHUpdate, IdNV = : idNVUpdate,"
                        + " Ma = : maUpdate, NgayTao =: ngayTaoUpdate, NgayThanhToan =: ngayThanhToanUpdate, "
                        + "TinhTrang =: tinhTrangUpdate,"
                        + " TenNguoiNhan =: tenNguoiNhanUpdate, DiaChi =: diaChiUpdate, Sdt =: sdtUpdate where Id = :idUpdate");
                query.setParameter("idKHUpdate", t.getKhachHang().getId());
                query.setParameter("idNVUpdate", t.getNhanVien().getId());
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("ngayTaoUpdate", t.getNgayTao());
                query.setParameter("ngayThanhToanUpdate", t.getNgayThanhToan());
                query.setParameter("tinhTrangUpdate", t.getTinhTrang());
                query.setParameter("tenNguoiNhanUpdate", t.getTenNguoiNhan());
                query.setParameter("diaChiUpdate", t.getDiaChi());
                query.setParameter("sdtUpdate", t.getSdt());
                query.setParameter("idUpdate", ma);
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
    public boolean delete(String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM GioHang where Id = :id");
                query.setParameter("id", ma);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.commit();
            }
        } finally {
            return check > 0;
        }
    }
//    public static void main(String[] args) {
//        new GioHangRepository().delete("510EA585-2883-4F70-BA32-034598A3CCB9");
//    }
}
