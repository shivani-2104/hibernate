package com.company.Day11_Assessment;

import com.company.utils.Utility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.uuid.LocalObjectUuidHelper;

import java.util.*;

public class UserDriver {
    public static void main(String[] args) {
//        insert();
        fetch();

    }

    private static void insert() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for(int i=1;i<=20;i++)
        {
            User data = new User();
            data.setMessage("Message - "+i);
            data.setUser_id(  ((int)(Math.random()*5))+1  );
            session.persist(data);
        }

        transaction.commit();
        session.close();
    }

    static void fetch()
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("select count(message) ,user_id from User GROUP BY user_id");

        List<Object[]> data;
        data = (List<Object[]>) ((org.hibernate.query.Query<?>) q).list();

        Map map=new HashMap();
        for(Object[] data1: data){
            Long noOfMsg = (Long)data1[0];
            Integer id = (Integer)data1[1];
           map.put(id,noOfMsg);
            System.out.print("id - "  +id+" No of msg - "+noOfMsg );
            System.out.println();
        }

        System.out.println("Entry with highest value: " + getMaxEntryInMapBasedOnValue(map));

        System.out.println(map);
        transaction.commit();
        session.close();
    }

public static <K, V extends Comparable<V> > Map.Entry<K, V>
 getMaxEntryInMapBasedOnValue(Map<K, V> map)
    {
        Map.Entry<K, V> entryWithMaxValue = null;
        for (Map.Entry<K, V> currentEntry : map.entrySet())
        {
            if ( entryWithMaxValue == null || currentEntry.getValue().compareTo(entryWithMaxValue.getValue()) > 0)
            {

                entryWithMaxValue = currentEntry;
            }
        }
        return entryWithMaxValue;
    }
}
