/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.ChiTietSanPhamCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.repository.IChiTietSanPhamRes;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRepository implements IChiTietSanPhamRes<ChiTietSanPham> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM ChiTietSanPham";

    @Override
    public List<ChiTietSanPham> getAll() {
        Query query = session.createQuery(fromTable, ChiTietSanPham.class);
        List<ChiTietSanPham> listChiTietSP = query.getResultList();
        return listChiTietSP;
    }

    public List<ChiTietSanPhamCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.ChiTietSanPhamCustomModel(B.id,A.ma,D.ma, C.ma, E.ma, B.namBH, B.moTa, B.soLuongTon, B.giaNhap, B.giaBan) "
                + "FROM ChiTietSanPham B INNER JOIN\n"
                + " DongSP E ON B.dongSP = E.id INNER JOIN\n"
                + " MauSac C ON B.mauSac = C.id INNER JOIN\n"
                + " NhaSanXuat D ON B.nhaSanXuat = D.id INNER JOIN\n"
                + " SanPham A ON B.sanPham = A.id";
        Query query = session.createQuery(hql);
        List<ChiTietSanPhamCustomModel> listChiTietSP = query.getResultList();
        return listChiTietSP;
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        ChiTietSanPham ctsp;
        String hql = fromTable + " Where Id = :id";
        Query query = session.createQuery(hql, ChiTietSanPham.class);
        query.setParameter("id", id);
        ctsp = (ChiTietSanPham) query.getSingleResult();
        return ctsp;
    }

    @Override
    public boolean add(ChiTietSanPham t) {
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
    public boolean update(ChiTietSanPham t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE ChiTietSanPham SET IdSP = : idSPUpdate, IdNSX =: idNSXUpdate, IdMauSac=: idMauSacUpdate, IdDongSP= : idDongSPUpdate, NamBH =: namBHUpdate, MoTa = : moTaUpdate, SoLuongTon =: soLuongTonUpdate, GiaNhap =: giaNhapUpdate, GiaBan =: giaBanUpdate  where Id = :idUpdate");
                query.setParameter("idSPUpdate", t.getSanPham().getId());
                query.setParameter("idNSXUpdate", t.getNhaSanXuat().getId());
                query.setParameter("idMauSacUpdate", t.getMauSac().getId());
                query.setParameter("idDongSPUpdate", t.getDongSP().getId());
                query.setParameter("namBHUpdate", t.getNamBH());
                query.setParameter("moTaUpdate", t.getMoTa());
                query.setParameter("soLuongTonUpdate", t.getSoLuongTon());
                query.setParameter("giaNhapUpdate", t.getGiaNhap());
                query.setParameter("giaBanUpdate", t.getGiaBan());
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
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM ChiTietSanPham where Id=:id ");
                query.setParameter("id", id);
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
        new ChiTietSanPhamRepository().getAllCustom().forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public List<ChiTietSanPham> getAllTen(String ten) {
        String hql = "FROM ChiTietSanPham where sanPham.ten =: tenhihi";
        Query query = session.createQuery(hql);
        query.setParameter("tenhihi", "%" + ten + "%");
        List<ChiTietSanPham> listChiTietSP = query.getResultList();
        return listChiTietSP;
    }

    @Override
    public boolean updateSoLuong(ChiTietSanPham t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE ChiTietSanPham SET SoLuongTon =: soLuongTonUpdate  where Id = :idUpdate");
                query.setParameter("soLuongTonUpdate", t.getSoLuongTon());
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
}
