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
public interface IServiceInterface<T> {

    List<T> getAll();

    T getOne(String ma);

    String add(T t);

    String update(T t, String id);

    String delete(String ma);
}
