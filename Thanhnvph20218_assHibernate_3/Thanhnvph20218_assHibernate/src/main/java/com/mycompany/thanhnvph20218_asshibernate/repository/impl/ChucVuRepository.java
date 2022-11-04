/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.ChucVuCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChucVu;
import com.mycompany.thanhnvph20218_asshibernate.repository.IInterface;
import com.mycompany.thanhnvph20218_asshibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class ChucVuRepository implements IInterface<ChucVu> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM ChucVu";

    @Override
    public List<ChucVu> getAll() {
        Query query = session.createQuery(fromTable, ChucVu.class);
        List<ChucVu> listChucVus = query.getResultList();
        return listChucVus;
    }

    public List<ChucVuCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.ChucVuCustomModel(A.id, A.ma, A.ten)"
                + " FROM ChucVu A";
        Query query = session.createQuery(hql);
        List<ChucVuCustomModel> listChucVus = query.getResultList();
        return listChucVus;

    }

    @Override
    public ChucVu getOne(String id) {
        ChucVu cv;
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, ChucVu.class);
        query.setParameter("ma", id);
        cv = (ChucVu) query.getSingleResult();
        return cv;
    }

    @Override
    public boolean add(ChucVu t) {
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
    public boolean update(ChucVu t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE ChucVu SET Ma = :maUpdate, Ten = :tenUpdate where Id = :idUpdate");
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
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM ChucVu where Ma=:ma ");
                query.setParameter("ma", ma);
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

//    public static void main(String[] args) {
//        List<ChucVuCustomModel> listSp = new ChucVuRepository().getAllCustom();
//        for (ChucVuCustomModel sanPhamCustomModel : listSp) {
//            System.out.println(sanPhamCustomModel.toString());
//        }
//    }
}
