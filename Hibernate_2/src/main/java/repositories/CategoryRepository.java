/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.Category;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author Ma
 */
public class CategoryRepository implements ICategoryRepo{

    private List<Category> lists;
    
    @Override
    public List<Category> getAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "From Category";
            TypedQuery<Category> query = session.createQuery(hql, Category.class);
            lists = query.getResultList();
            return lists;
        }
    }

    @Override
    public Category getCatgoryById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "From Category where id = :id";
            TypedQuery<Category> query = session.createQuery(hql, Category.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }
    
}
