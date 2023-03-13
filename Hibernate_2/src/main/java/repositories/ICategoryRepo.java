/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainmodels.Category;
import java.util.List;

/**
 *
 * @author Ma
 */
public interface ICategoryRepo {
    List<Category> getAll();
    
    Category getCatgoryById(int id);
}
