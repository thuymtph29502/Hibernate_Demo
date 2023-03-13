/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodels.Category;
import java.util.List;
import repositories.CategoryRepository;
import repositories.ICategoryRepo;

/**
 *
 * @author Ma
 */
public class CategoryService implements ICategoryService{

    private ICategoryRepo repo = new CategoryRepository();
    @Override
    public List<Category> getAll() {
        return repo.getAll();
    }

    @Override
    public Category getCatgoryById(int id) {
        return repo.getCatgoryById(id);
    }
    
}
