package com.company.Day11_Assessment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static com.company.utils.Utility.getSession;

public class CRUD_Ex {
    public static void main(String[] args) {
//readExample();
//        deleteExample();
//        insertData();
        updateExample();
    }
//     R
    private static void readExample() {
        Session session = getSession();
        List<Data2> list = session.createQuery("from Data2",Data2.class).getResultList();
        System.out.println(list);
    }

    // D
    private static void deleteExample() {
        Session session = getSession();
        Transaction transaction=session.beginTransaction();
        Data2 data = new Data2();
        data.setId(1);
        session.remove(data);
        transaction.commit();
    }
    // C
    private static void insertData() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Data2 data1 = new Data2();
        data1.setName("Shivani");
        data1.setLocation("Indore");

        session.persist(data1);

        transaction.commit();
    }
    // U
    private static void updateExample(){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Data2 data =session.get(Data2.class,2);
        data.setName("name-updated");
        data.setLocation("Location-updated");
        session.persist(data);
        transaction.commit();
        session.close();
    }
}
