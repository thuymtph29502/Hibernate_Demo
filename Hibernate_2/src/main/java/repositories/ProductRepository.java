/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.Category;
import domainmodels.Product;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author Ma
 */
public class ProductRepository implements IProductRepo{

    private List<Product> lists;
    
    @Override
    public List<Product> getAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "From Product";
            TypedQuery<Product> query = session.createQuery(hql, Product.class);
            lists = query.getResultList();
            return lists;
        }
    }

    @Override
    public Product getProductbyId(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "From Product where id = :id";
            TypedQuery<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public int addProduct(Product p) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(p);
                trans.commit();
                return 1;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
                return -1;
            }
        }
    }

    @Override
    public int updateProduct(Product p, int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "UPDATE Product set name = :name, description = :description, price = :price, categoryId = :categoryId where id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("name", p.getName());
                query.setParameter("description", p.getDescription());
                query.setParameter("price", p.getPrice());
                query.setParameter("categoryId", p.getCategoryId());
                query.setParameter("id", id);
                int result = query.executeUpdate();
                trans.commit();
                return result;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
                return -1;
            }
        }
    }

    @Override
    public int deleteProduct(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "Delete Product p where p.id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                int result = query.executeUpdate();
                trans.commit();
                return result;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                trans.rollback();
                return -1;
            }
        }
    }

    @Override
    public List<Product> getProGroupByCategory(Category c) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "From Product where categoryId = :categoryId";
            TypedQuery<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("categoryId", c);
            lists = query.getResultList();
            return lists;
        }
    }
    
}
