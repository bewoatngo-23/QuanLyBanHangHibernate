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
public interface IHoaDonRes<T> {

    List<T> getAll();

    T getOne(String ma);

    boolean add(T t);

    boolean update(T t, String ma);

    boolean delete(String ma);

    List<T> getAllByTinhTrang(int tinhTrang);

    T getOneMa(String ma);

    boolean updateTinhTrang(T t, String ma);
}
