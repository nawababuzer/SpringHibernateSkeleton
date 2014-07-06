package com.abz.skeleton.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abz.skeleton.model.Product;
import com.abz.skeleton.service.ProductService;

public class SkeletonMain {
    public static void main(String[] args)
    {
           //Build application context by reading spring-config.xml
           ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});

           //Get an instance of ProductService class;
           ProductService prdSvc = (ProductService) ctx.getBean("productService");

           //Call getProduct method of ProductService
           Product prod = prdSvc.getProduct(1);

           System.out.println("Got the product:"+prod.getName());
    }
}
