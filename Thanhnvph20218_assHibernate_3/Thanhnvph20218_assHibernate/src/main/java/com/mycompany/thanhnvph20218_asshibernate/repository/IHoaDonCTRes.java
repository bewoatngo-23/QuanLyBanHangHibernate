/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.repository;

import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface IHoaDonCTRes<T> {

    List<T> getAll();

    T getOne(String idHd, String idCtsp);

    boolean add(T t);

    boolean update(T t, String idHd, String idCtsp);

    boolean delete(String idHd, String idCtsp);
    
    List<T> getAllHoaDonCT(String idHd);
}
