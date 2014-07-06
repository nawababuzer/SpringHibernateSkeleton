package com.abz.skeleton.dao.impl;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.abz.skeleton.dao.BaseDao;
import com.abz.skeleton.dao.ProductDao;
import com.abz.skeleton.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public Product getProduct(int id) {
        System.out.println("In DAO class");
        try{
               return (Product) getSession().get(Product.class, id);
        }
        catch(HibernateException e){
               System.out.println("Error occured while getting data");
        }
        return null;
    }
}
