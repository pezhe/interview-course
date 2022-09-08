package ru.pezhe.interview.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static final SessionFactory sessionFactory
            = buildSessionFactory();
    private static SessionFactory buildSessionFactory()
    {
        try {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
