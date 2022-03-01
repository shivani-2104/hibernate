package com.company.Day11_Assessment;

import com.company.Day10Part2.Person;
import com.company.Day10Part2.PhoneNumber;
import com.company.utils.Utility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DriverProductsStore {
    public static void main(String[] args) {

//        insertInitial();
//        insertNewPhoneNumber();
//        Session session = Utility.getSession();
//        Transaction transaction = session.beginTransaction();
//        StoreClass person = session.get(StoreClass.class,1);
//        session.remove(person);
//        transaction.commit();
//        session.close();
        remove();
    }

    private static void insertNewPhoneNumber() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        StoreClass storeObject = session.get(StoreClass.class,3);
        ProductsClass productObject = new ProductsClass();

        productObject.setName("product-name-6");
        productObject.setStore(storeObject);

        session.persist(productObject);
        transaction.commit();
        session.close();
    }

    private static void insertInitial() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();

        ProductsClass productObject = new ProductsClass();

        StoreClass storeObject= new StoreClass();
        storeObject.setName("name-3");
        storeObject.setAddress("Indore");

        productObject.setName("Product-name-5");
       productObject.setStore(storeObject);

        session.persist(storeObject);
        session.persist(productObject);
        transaction.commit();
        session.close();
    }
    private static void remove() {

        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
//        ProductsClass ob=session.get(ProductsClass.class,3);
//        session.remove(ob);

        StoreClass store_ob=session.get(StoreClass.class,3);
        session.remove(store_ob);

        transaction.commit();
        session.close();
    }
}
