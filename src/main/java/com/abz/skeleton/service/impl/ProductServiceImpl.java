package com.abz.skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abz.skeleton.dao.ProductDao;
import com.abz.skeleton.model.Product;
import com.abz.skeleton.service.ProductService;


@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    public void setProdDAO(ProductDao prodDAO) {
           this.productDao = prodDAO;
    }

    @Override
    public Product getProduct(int id){
           System.out.println("In Service class...will call DAO");
           return productDao.getProduct(id);
    }
}
