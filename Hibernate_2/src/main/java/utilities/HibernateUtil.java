/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import domainmodels.Category;
import domainmodels.Product;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Ma
 */
public class HibernateUtil {

    public static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Đọc cấu hình Hibernate từ tệp hibernate.cfg.xml
            Configuration cfg = new Configuration();
            
            Properties pros = new Properties();
            pros.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            pros.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=CuaHang_Hibernate");
            pros.put(Environment.USER, "sa");
            pros.put(Environment.PASS, "Mathuthuysa");
            
            cfg.setProperties(pros);
            cfg.addAnnotatedClass(Category.class);
            cfg.addAnnotatedClass(Product.class);

            //Tạo đối tượng ServiceRegistry từ cấu hình hibernate
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

            //Tạo đối tượng SessionFactory từ ServiceRegistry
            return cfg.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
          throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
