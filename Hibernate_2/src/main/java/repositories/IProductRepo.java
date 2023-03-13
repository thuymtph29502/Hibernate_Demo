/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainmodels.Category;
import domainmodels.Product;
import java.util.List;

/**
 *
 * @author Ma
 */
public interface IProductRepo {

    List<Product> getAll();

    Product getProductbyId(int id);

    int addProduct(Product p);

    int updateProduct(Product p, int id);

    int deleteProduct(int id);
    
    List<Product> getProGroupByCategory(Category c);
}
