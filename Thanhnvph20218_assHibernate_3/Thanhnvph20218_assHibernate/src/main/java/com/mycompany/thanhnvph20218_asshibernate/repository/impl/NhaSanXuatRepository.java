/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhaSanXuatCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhaSanXuat;
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
public class NhaSanXuatRepository implements IInterface<NhaSanXuat> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM NhaSanXuat";

    @Override
    public List<NhaSanXuat> getAll() {
        Query query = session.createQuery(fromTable, NhaSanXuat.class);
        List<NhaSanXuat> listNhaSanXuats = query.getResultList();
        return listNhaSanXuats;
    }

    public List<NhaSanXuatCustomModel> getAllCustomModel() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.NhaSanXuatCustomModel(A.id, A.ma, A.ten) "
                + "FROM NhaSanXuat A";
        Query query = session.createQuery(hql);
        List<NhaSanXuatCustomModel> listNhaSanXuats = query.getResultList();
        return listNhaSanXuats;
    }

    @Override
    public NhaSanXuat getOne(String id) {
        NhaSanXuat nsx;
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, NhaSanXuat.class);
        query.setParameter("ma", id);
        nsx = (NhaSanXuat) query.getSingleResult();
        return nsx;
    }

    @Override
    public boolean add(NhaSanXuat t) {
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
    public boolean update(NhaSanXuat t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE NhaSanXuat SET Ma = :maUpdate, Ten = :tenUpdate where Id = :idUpdate");
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
                Query query = session.createQuery("DELETE FROM NhaSanXuat where Ma=:ma ");
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
////        new NhaSanXuatRepository().delete("NSX1");
//        new NhaSanXuatRepository().getAll().forEach(s -> System.out.println(s.toString()));
//    }

}
