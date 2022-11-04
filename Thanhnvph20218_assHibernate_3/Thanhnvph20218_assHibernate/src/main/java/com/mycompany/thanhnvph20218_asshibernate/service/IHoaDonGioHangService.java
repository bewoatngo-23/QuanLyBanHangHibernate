/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.service;

import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface IHoaDonGioHangService<T> {

    List<T> getAll();

    T getOne(String id1, String id2);

    String add(T t);

    String update(T t, String id1, String id2);

    String delete(String id1, String id2);
    
    List<T> getOneHoaDonCT(String id1);
}
