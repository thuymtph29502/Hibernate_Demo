/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.Category;
import domainmodels.Product;
import java.util.List;

/**
 *
 * @author Ma
 */
public interface IProductService {

    List<Product> getAll();

    Product getProductbyId(int id);

    String addProduct(Product p);

    String updateProduct(Product p, int id);

    String deleteProduct(int id); 
    
    List<Product> getProGroupByCategory(Category c);
}
