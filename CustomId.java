package com.company.Day11_Assessment;


        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.SequenceGenerator;
        import org.hibernate.HibernateException;
        import org.hibernate.engine.spi.SharedSessionContractImplementor;
        import org.hibernate.id.factory.spi.StandardGenerator;

        import java.lang.annotation.Annotation;
        import java.util.Random;

public class CustomId implements StandardGenerator {
    private  static int a;



    private final String DEFAULT_SEQUENCE_NAME="my_seq";


    Random randomObj = new Random();
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        return ++a;

    }
}
