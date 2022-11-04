/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDon;
import com.mycompany.thanhnvph20218_asshibernate.repository.IHoaDonRes;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements IHoaDonRes<HoaDon> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM HoaDon";
    private String hql1 = "FROM HoaDon A where A.tinhTrang =: tinhTranghihi";

    @Override
    public List<HoaDon> getAll() {
        Query query = session.createQuery(fromTable, HoaDon.class);
        List<HoaDon> listHoaDons = query.getResultList();
        return listHoaDons;
    }

    public List<HoaDonCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.HoaDonCustomModel(B.id, A.ma, C.ma, B.ma, B.ngayTao, B.ngayThanhToan, B.ngayShip, B.ngayNhan, B.tinhTrang, B.tenNguoiNhan, B.diaChi, B.sdt) "
                + "FROM KhachHang A INNER JOIN HoaDon B ON A.id = B.khachHang "
                + "INNER JOIN NhanVien C ON B.nhanVien = C.id";
        Query query = session.createQuery(hql);
        List<HoaDonCustomModel> listHoaDons = query.getResultList();
        return listHoaDons;
    }

    @Override
    public HoaDon getOne(String ma) {
        HoaDon hd;
        String hql = fromTable + " where Id =: id";
        Query query = session.createQuery(hql, HoaDon.class);
        query.setParameter("id", ma);
        hd = (HoaDon) query.getSingleResult();
        return hd;
    }

    @Override
    public boolean add(HoaDon t) {
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
    public boolean update(HoaDon t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE HoaDon SET IdKH = : idKHUpdate, IdNV = : idNVUpdate,"
                        + " Ma = : maUpdate, NgayTao =: ngayTaoUpdate, NgayThanhToan =: ngayThanhToanUpdate, "
                        + "NgayShip =: ngayShipUpdate, NgayNhan=:ngayNhanUpdate, TinhTrang =: tinhTrangUpdate,"
                        + " TenNguoiNhan =: tenNguoiNhanUpdate, DiaChi =: diaChiUpdate, Sdt =: sdtUpdate where Id = :idUpdate");
                query.setParameter("idKHUpdate", t.getKhachHang().getId());
                query.setParameter("idNVUpdate", t.getNhanVien().getId());
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("ngayTaoUpdate", t.getNgayTao());
                query.setParameter("ngayThanhToanUpdate", t.getNgayThanhToan());
                query.setParameter("ngayShipUpdate", t.getNgayShip());
                query.setParameter("ngayNhanUpdate", t.getNgayNhan());
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
                Query query = session.createQuery("DELETE FROM HoaDon where Id=:id ");
                query.setParameter("id", ma);
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
    public List<HoaDon> getAllByTinhTrang(int tinhTrang) {
        Query query = session.createQuery(hql1, HoaDon.class);
        query.setParameter("tinhTranghihi", tinhTrang);
        List<HoaDon> listHoaDons = query.getResultList();
        return listHoaDons;
    }

    @Override
    public HoaDon getOneMa(String ma) {
        HoaDon hd;
        String hql = fromTable + " where ma =: ma";
        Query query = session.createQuery(hql, HoaDon.class);
        query.setParameter("ma", ma);
        hd = (HoaDon) query.getSingleResult();
        return hd;
    }

    @Override
    public boolean updateTinhTrang(HoaDon t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE HoaDon SET TinhTrang =: tinhTrangUpdate where Ma = :maUpdate");
                query.setParameter("tinhTrangUpdate", t.getTinhTrang());
                query.setParameter("maUpdate", ma);
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
        List<HoaDonCustomModel> listSp = new HoaDonRepository().getAllCustom();
        for (HoaDonCustomModel sanPhamCustomModel : listSp) {
            System.out.println(sanPhamCustomModel.toString());
        }
    }
}
