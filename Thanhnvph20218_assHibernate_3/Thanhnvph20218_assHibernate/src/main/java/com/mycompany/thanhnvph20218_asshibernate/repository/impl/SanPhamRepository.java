/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.SanPhamCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham;
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
public class SanPhamRepository implements IInterface<SanPham> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM SanPham";

    @Override
    public List<SanPham> getAll() {
        Query query = session.createQuery(fromTable, SanPham.class);
        List<SanPham> listSanPhams = query.getResultList();
        return listSanPhams;
    }

    public List<SanPhamCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.SanPhamCustomModel(S.id, S.ma, S.ten) "
                + "FROM com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham S";
        Query query = session.createQuery(hql);
        List<SanPhamCustomModel> listSanPhamRes = query.getResultList();
//        SanPhamCustomModel sanPhamCustomModel = listSanPhamRes.get(0);
        return listSanPhamRes;
    }

    @Override
    public SanPham getOne(String id) {
        SanPham sanPham;
//        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
//            String hql = "SELECT d FROM SanPham d WHERE d.Id = :id";
//            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
//            query.setParameter("id", id);
//            sanPham = query.getSingleResult();
//        }
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, SanPham.class);
        query.setParameter("ma", id);
        sanPham = (SanPham) query.getSingleResult();
        return sanPham;
    }

    @Override
    public boolean add(SanPham t) {
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
    public boolean update(SanPham t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE SanPham SET Ma = :maUpdate, Ten = :tenUpdate where Id = :idUpdate");
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("tenUpdate", t.getTen());
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
        int result = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE SanPham  WHERE ma = :ma";
                Query query = session.createQuery(hql);
                query.setParameter("ma", ma);
                result = query.executeUpdate();
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }

        } finally {
            return result > 0;
        }
    }

//    public static void main(String[] args) {
//////        SanPham sanPham = new SanPham();
//////        sanPham.setMa("SP100");
//////        sanPham.setTen("yeu ai hihi");
//////        new SanPhamRepository().update(sanPham, "D2E52B20-8B0A-4EFE-A0D8-F67C12F4FFD0");
//////        new SanPhamRepository().getAll().forEach(s -> System.out.println(s.toString()));
////        SanPham sp = new SanPhamRepository().getOne("D2E52B20-8B0A-4EFE-A0D8-F67C12F4FFD0");
////        System.out.println(sp);
//        List<SanPhamCustomModel> listSp = new SanPhamRepository().getAllCustom();
//        for (SanPhamCustomModel sanPhamCustomModel : listSp) {
//            System.out.println(sanPhamCustomModel.toString());
//        }
//
//    }
}
