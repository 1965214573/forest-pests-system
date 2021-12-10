package com.example.dao.impl;

public class CommonDaoImplTest {

    public static void main(String[] args) {
        CommonDaoImpl commonDao = new CommonDaoImpl();
        commonDao.getRootMenuList(1).forEach(System.out::println);
    }
}