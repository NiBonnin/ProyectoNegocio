/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.annotation.Resource;
import modelo.pojo.Cliente;
import modelo.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Nico
 */
public class GenericDao {
    
    public static List<Cliente> layDS(){
        List<Cliente> lst = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Cliente";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    public <T> T save(final T o){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        Object object = (T) session.save(o);
        trans.commit();
        return (T) object;
    }
    

    
    public void delete(final Object o){
       Session session=HibernateUtil.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
       session.delete(o);
       trans.commit();
    }

    /***/
    public <T> T get(final Class<T> type, final int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        Object object = (T) session.get(type, id);
        trans.commit();
        return (T) object;
    }

    /***/
    public <T> T merge(final T o)   {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        Object object = (T) session.merge(o);
        trans.commit();
        return (T) object;
      //return (T) sessionFactory.getCurrentSession().merge(o);
    }

    /***/
    public <T> void saveOrUpdate(final T o){
       Session session=HibernateUtil.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
       session.saveOrUpdate(o);
       trans.commit();
      //sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    public <T> List<T> getAll(final Class<T> type) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        final Criteria crit = session.createCriteria(type);
        List<T> list = crit.list();
        trans.commit();
        return list;
        /*final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();*/
    }

}
