/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import modelo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;





/**
 *
 * @author Nico
 */

    public class ClienteResource {
        ApplicationContext appContext;

        
        
        public List<Cliente> index(Cliente paramBean) {
            GenericDao dao = (GenericDao) appContext.getBean("ClienteDao");
            List<Cliente> result = dao.read();
            System.out.println("Get all employees: size = " + result.size());
            return result;
        }


        public Object show(int id) {
            GenericDao dao = (GenericDao) appContext.getBean("ClienteDao");
            System.out.println("Get employees -> id = " + id);
            return dao.read(id);
        }


        public Serializable create(Cliente obj) {
            GenericDao dao = (GenericDao) appContext.getBean("Cliente.hbm");
            return dao.create(obj);
        }
        public <T> T save(final T o){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        Object object = (T) session.save(o);
        trans.commit();
        return (T) object;
    }


        
        public void update(Cliente obj, String id) {
            GenericDao dao = (GenericDao) appContext.getBean("ClienteDao");
            dao.update(obj);
        }


        public void destroy(int id) throws Exception {
            GenericDao dao = (GenericDao) appContext.getBean("ClienteDao");
            dao.delete(id);
        }
    }
