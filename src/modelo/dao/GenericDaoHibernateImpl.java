/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author Nico
 */
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
 public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

        private Class<T> type;
        Class<RuntimeException> rollbackFor;
        boolean readOnly;
        
        @Autowired
        private SessionFactory sessionFactory;

        
        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public GenericDaoHibernateImpl(Class<T> type) {
            this.type = type;
        }

        // Not showing implementations of getSession() and setSessionFactory()
        private Session getSession() {
            Session session = sessionFactory.getCurrentSession();
            return session;
        }

        public PK create(T o) {
            return (PK) getSession().save(o);
        }

        public void update(T o) {
            getSession().update(o);
        }


        public T read(PK id) {
            return (T) getSession().get(type, id);
        }


        public List<T> read() {
            return (List<T>) getSession().createCriteria(type).list();
        }


        public void delete(PK id) {
            T o = read(id);
            getSession().delete(o);
        }

        public void delete(T o) {
            getSession().delete(o);
        }
 }
