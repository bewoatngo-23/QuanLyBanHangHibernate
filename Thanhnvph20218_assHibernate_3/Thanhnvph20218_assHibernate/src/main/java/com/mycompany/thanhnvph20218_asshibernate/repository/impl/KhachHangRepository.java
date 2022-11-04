/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.KhachHangCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.CuaHang;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.KhachHang;
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
public class KhachHangRepository implements IInterface<KhachHang> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM KhachHang";

    @Override
    public List<KhachHang> getAll() {
        Query query = session.createQuery(fromTable, KhachHang.class);
        List<KhachHang> listKhachHangs = query.getResultList();
        return listKhachHangs;
    }

    public List<KhachHangCustomModel> getAllCustom() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.KhachHangCustomModel(A.id,A.ma,A.ten,A.tenDem,A.ho,A.ngaySinh,A.sdt,A.diaChi,A.thanhPho,A.quocGia,A.matKhau)"
                + "FROM KhachHang A";
        Query query = session.createQuery(hql);
        List<KhachHangCustomModel> listKhachHangs = query.getResultList();
        return listKhachHangs;
    }

    @Override
    public KhachHang getOne(String id) {
        KhachHang kh;
        String hql = fromTable + " Where Ma= :ma";
        Query query = session.createQuery(hql, KhachHang.class);
        query.setParameter("ma", id);
        kh = (KhachHang) query.getSingleResult();
        return kh;
    }

    @Override
    public boolean add(KhachHang t) {
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
    public boolean update(KhachHang t, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE KhachHang SET Ma = :maUpdate, Ten = :tenUpdate,TenDem = : tenDemUpdate, Ho = : hoUpdate, NgaySinh = : ngaySinhUpdate, Sdt = : sdtUpdate, DiaChi =:diaChiUpdate, ThanhPho =:thanhPho,QuocGia =:quocGia, MatKhau = : matKhauUpdate  where Id = :idUpdate");
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("tenUpdate", t.getTen());
                query.setParameter("tenDemUpdate", t.getTenDem());
                query.setParameter("hoUpdate", t.getHo());
                query.setParameter("ngaySinhUpdate", t.getNgaySinh());
                query.setParameter("sdtUpdate", t.getSdt());
                query.setParameter("diaChiUpdate", t.getDiaChi());
                query.setParameter("thanhPho", t.getThanhPho());
                query.setParameter("quocGia", t.getQuocGia());
                query.setParameter("matKhauUpdate", t.getMatKhau());
                query.setParameter("idUpdate", id);
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
                Query query = session.createQuery("DELETE FROM KhachHang where Ma=:ma ");
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
