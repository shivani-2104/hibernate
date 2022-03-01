package com.company.Day11_Assessment;

import com.company.Day7.Student;
import com.company.Day7.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class DataDriver_Using_Mapping {
    public static void main(String[] args) {
        Data data = new Data();
data.setName("Sonali");
data.setLocation("Pune");
//data.setId(1);
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Student.class);
        configuration.addResource("DataDriver_Using_Mapping.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(data);
        transaction.commit();
        session.close();
    }
}
