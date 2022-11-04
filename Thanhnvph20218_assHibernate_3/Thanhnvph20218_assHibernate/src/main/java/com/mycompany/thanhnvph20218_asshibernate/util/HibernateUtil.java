/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.util;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChucVu;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.CuaHang;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.DongSP;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHang;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.GioHangChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDon;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDonChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.KhachHang;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhaSanXuat;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhanVien;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Admin
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
