package com.company.Day11_Assessment;

import com.company.Day9Part2.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Data2Driver_Using_Annotation {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Data2.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Data2 data = new Data2();
        data.setName("SHIVANI");
        data.setLocation("BHOPAL");
        session.persist(data);
        transaction.commit();
        session.close();


    }
}
