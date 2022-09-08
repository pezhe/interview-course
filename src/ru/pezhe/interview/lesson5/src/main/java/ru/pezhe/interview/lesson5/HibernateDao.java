package ru.pezhe.interview.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class HibernateDao<E> {

    private final SessionFactory sessionFactory;
    private final Class<E> entityType;

    public HibernateDao(SessionFactory sessionFactory, Class<E> entityType) {
        this.sessionFactory = sessionFactory;
        this.entityType = entityType;
    }

    public List<E> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<E> query = session.createQuery("from " + entityType.getSimpleName(), entityType);
            return query.list();
        }
    }

    public Optional<E> findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            E result = session.get(entityType, id);
            return Optional.of(result);
        }
    }

    public void save(E entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
    }

    public void update(E entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
    }

    public void deleteById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(session.get(entityType, id));
            session.getTransaction().commit();
        }
    }
}
