/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.CuaHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.CuaHang;
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
public class CuaHangRepository implements IInterface<CuaHang> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM CuaHang";

    @Override
    public List<CuaHang> getAll() {
        Query query = session.createQuery(fromTable, CuaHang.class);
        List<CuaHang> listCuaHangs = query.getResultList();
        return listCuaHangs;
    }

    public List<CuaHangCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.CuaHangCustomModel(A.id, A.ten, A.ma, A.diaChi, A.thanhPho, A.quocGia)"
                + " FROM CuaHang A";
        Query query = session.createQuery(hql);
        List<CuaHangCustomModel> listCuaHangs = query.getResultList();
        return listCuaHangs;
    }

    @Override
    public CuaHang getOne(String id) {
        CuaHang ch;
        String hql = fromTable + " Where ma = :ma";
        Query query = session.createQuery(hql, CuaHang.class);
        query.setParameter("ma", id);
        ch = (CuaHang) query.getSingleResult();
        return ch;
    }

    @Override
    public boolean add(CuaHang t) {
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
    public boolean update(CuaHang t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE CuaHang SET Ma = :maUpdate, Ten = :tenUpdate, DiaChi =:diaChiUpdate, ThanhPho =:thanhPho,QuocGia =:quocGia  where Id = :idUpdate");
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("tenUpdate", t.getTen());
                query.setParameter("diaChiUpdate", t.getDiaChi());
                query.setParameter("thanhPho", t.getThanhPho());
                query.setParameter("quocGia", t.getQuocGia());
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
                Query query = session.createQuery("DELETE FROM CuaHang where Ma=:ma ");
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
}
