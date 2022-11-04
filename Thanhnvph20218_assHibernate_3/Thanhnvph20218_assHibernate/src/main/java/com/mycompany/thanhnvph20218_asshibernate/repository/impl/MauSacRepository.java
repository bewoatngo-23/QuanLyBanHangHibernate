/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.MauSacCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
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
public class MauSacRepository implements IInterface<MauSac> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM MauSac";

    @Override
    public List<MauSac> getAll() {
        Query query = session.createQuery(fromTable, MauSac.class);
        List<MauSac> listMauSacs = query.getResultList();
        return listMauSacs;
    }

    public List<MauSacCustomModel> getAllCustomModel() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.MauSacCustomModel(A.id, A.ma, A.ten) "
                + "FROM MauSac A";
        Query query = session.createQuery(hql);
        List<MauSacCustomModel> listMauSacs = query.getResultList();
        return listMauSacs;
    }

    @Override
    public MauSac getOne(String id) {
        MauSac ms;
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, MauSac.class);
        query.setParameter("ma", id);
        ms = (MauSac) query.getSingleResult();
        return ms;
    }

    @Override
    public boolean add(MauSac t) {
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
    public boolean update(MauSac t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE MauSac SET Ma = :maUpdate, Ten = :tenUpdate where Id = :idUpdate");
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
                Query query = session.createQuery("DELETE FROM MauSac where Ma=:ma ");
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
//        List<MauSacCustomModel> listSp = new MauSacRepository().getAllCustomModel();
//        for (MauSacCustomModel sanPhamCustomModel : listSp) {
//            System.out.println(sanPhamCustomModel.toString());
//        }
//    }
}
