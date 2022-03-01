package com.company.Day11_Assessment;

import com.company.Day9Part2.StudentList;
import com.company.utils.Utility;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CatDriver {
    public static void main(String[] args) {
//        allResult();
//        Session session = Utility.getSession();
//        CriteriaQuery<Integer> critertiaQuery = sumOfMarks(session);
//
//        System.out.println(session.createQuery(critertiaQuery).getSingleResult());
//max(session);
//        insert();
        desiredResult();

    }
    private static void insert() {
        String name[]={"mm","aa","gg","yy"};
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Cat1.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for(int i=1;i<=20;i++)
        {
            Cat1 data = new Cat1();
            data.setName(name[(int) (Math.random()*4)]);
            data.setAge(((int)(Math.random()*30))+1 );
            data.setWeight(((int)(Math.random()*30))+1 );
            session.persist(data);
        }

        transaction.commit();
        session.close();
    }
    static void allResult()
    {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Cat1.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Cat1.class);

        Root root=criteriaQuery.from(Cat1.class);


        criteriaQuery.select(root);
        System.out.println(session.createQuery(criteriaQuery).getResultList());
    }
    static void desiredResult()
    {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Cat1.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Cat1.class);

        Root root=criteriaQuery.from(Cat1.class);

        CriteriaQuery  q= criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"),"m%"));
        CriteriaQuery  q2= q.select(root).where(criteriaBuilder.gt(root.get("weight"),10));
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("age")));
        System.out.println(session.createQuery(criteriaQuery).getResultList());





//criteriaQuery.select(root).where(root.get("name")).;
//List list=new ArrayList();
//list.add(criteriaBuilder.asc(root.get("age")));
//        System.out.println((Integer)criteriaBuilder.asc(root.get("age")));
//        q2.select(root).getOrderList(criteriaBuilder.asc(root.get("age")));
//        System.out.println(list);
    }



}
