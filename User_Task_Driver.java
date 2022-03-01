package com.company.Day11_Assessment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class User_Task_Driver {
    public static void main(String[] args) {
        insert();


    }

    private static void insert() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User_Task.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User_Task data = new User_Task();
        data.setName("SHIVANI");
        session.persist(data);
        transaction.commit();
        session.close();

    }
}
