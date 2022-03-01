package com.company.Day11_Assessment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductClassDriver {
   static  int val=0;
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(ProductClass.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ProductClass data = new ProductClass();

        data.setName("Computer");
        data.setPrice(10000);
        session.persist(data);
        transaction.commit();
        session.close();
    }
}
