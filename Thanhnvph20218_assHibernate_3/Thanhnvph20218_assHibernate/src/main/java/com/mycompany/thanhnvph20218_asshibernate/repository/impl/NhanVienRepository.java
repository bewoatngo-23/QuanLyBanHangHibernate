/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository.impl;

import com.mycompany.thanhnvph20218_asshibernate.customModels.NhanVienCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhanVien;
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
public class NhanVienRepository implements IInterface<NhanVien> {

    private static final Session session = HibernateUtil.getFACTORY().openSession();
    private String fromTable = "FROM NhanVien";

    @Override
    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable, NhanVien.class);
        List<NhanVien> listNhanViens = query.getResultList();
        return listNhanViens;
    }

    public List<NhanVienCustomModel> getAllCustomModel() {
        String hql = "SELECT new com.mycompany.thanhnvph20218_asshibernate.customModels.NhanVienCustomModel(B.id,B.ma, B.ten, B.tenDem, B.ho,B.gioiTinh, B.ngaySinh, B.diaChi, B.sdt, B.matKhau, A.ten, C.ten, B.trangThai)"
                + "FROM ChucVu A INNER JOIN NhanVien B ON A.id = B.cv "
                + "INNER JOIN CuaHang C ON B.ch = C.id";
        Query query = session.createQuery(hql);
        List<NhanVienCustomModel> listNhanViens = query.getResultList();
        return listNhanViens;
    }

    @Override
    public NhanVien getOne(String id) {
        NhanVien nv;
        String hql = fromTable + " Where Ma = :ma";
        Query query = session.createQuery(hql, NhanVien.class);
        query.setParameter("ma", id);
        nv = (NhanVien) query.getSingleResult();
        return nv;
    }

    @Override
    public boolean add(NhanVien t) {
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
    public boolean update(NhanVien t, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien SET Ma = :maUpdate, Ten = :tenUpdate,"
                        + "TenDem = : tenDemUpdate, Ho = : hoUpdate, GioiTinh =: gioiTinhUpdate,  NgaySinh = : ngaySinhUpdate,"
                        + " Sdt = : sdtUpdate, DiaChi =:diaChiUpdate, MatKhau = : matKhauUpdate, TrangThai =: trangThaiUpdate,IdCH =: idCHUpdate, IdCV =:idCVUpdate, IdGuiBc = :idGuiBCUpdate   "
                        + " where Id = :idUpdate");
                query.setParameter("maUpdate", t.getMa());
                query.setParameter("tenUpdate", t.getTen());
                query.setParameter("tenDemUpdate", t.getTenDem());
                query.setParameter("hoUpdate", t.getHo());
                query.setParameter("gioiTinhUpdate", t.getGioiTinh());
                query.setParameter("ngaySinhUpdate", t.getNgaySinh());
                query.setParameter("sdtUpdate", t.getSdt());
                query.setParameter("diaChiUpdate", t.getDiaChi());
                query.setParameter("matKhauUpdate", t.getMatKhau());
                query.setParameter("idCHUpdate", t.getCh().getId());
                query.setParameter("idCVUpdate", t.getCv().getId());
                query.setParameter("idGuiBCUpdate", null);
                query.setParameter("trangThaiUpdate", t.getTrangThai());
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
                Query query = session.createQuery("DELETE FROM NhanVien where Id=:id ");
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

//    public static void main(String[] args) {
//        List<NhanVienCustomModel> listSp = new NhanVienRepository().getAllCustomModel();
//        for (NhanVienCustomModel sanPhamCustomModel : listSp) {
//            System.out.println(sanPhamCustomModel.toString());
//        }
//    }
}
