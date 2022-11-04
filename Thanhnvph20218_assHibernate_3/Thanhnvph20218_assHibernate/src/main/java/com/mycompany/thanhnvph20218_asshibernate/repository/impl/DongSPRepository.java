/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.DongSPCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.DongSP;
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
public class DongSPRepository implements IInterface<DongSP> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM DongSP";

    @Override
    public List<DongSP> getAll() {
        Query query = session.createQuery(fromTable, DongSP.class);
        List<DongSP> listDongSPs = query.getResultList();
        return listDongSPs;
    }
    
    public List<DongSPCustomModel> getAllCustom(){
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.DongSPCustomModel(A.id, A.ma, A.ten)"
                + " FROM DongSP A";
        Query query = session.createQuery(hql);
        List<DongSPCustomModel> listDongSPs = query.getResultList();
        return listDongSPs;
        }
    @Override
    public DongSP getOne(String id) {
        DongSP dongSp;
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, DongSP.class);
        query.setParameter("ma", id);
        dongSp = (DongSP) query.getSingleResult();
        return dongSp;
    }

    @Override
    public boolean add(DongSP t) {
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
    public boolean update(DongSP t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE DongSP SET Ma = :maUpdate, Ten = :tenUpdate where Id = :idUpdate");
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
                Query query = session.createQuery("DELETE FROM DongSP where Ma=:ma ");
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
//        DongSP dongSp = new DongSPRepository().getOne("CD64C717-2FE2-49B5-928B-04640F5952AF");
//        System.out.println(dongSp);
//    }
}
