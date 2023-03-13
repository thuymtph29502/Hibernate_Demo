/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodels.Category;
import domainmodels.Product;
import java.util.List;
import repositories.IProductRepo;
import repositories.ProductRepository;

/**
 *
 * @author Ma
 */
public class ProductService implements IProductService{

    private IProductRepo repo = new ProductRepository();
    
    @Override
    public List<Product> getAll() {
        return repo.getAll();
    }

    @Override
    public Product getProductbyId(int id) {
        return repo.getProductbyId(id);
    }

    @Override
    public String addProduct(Product p) {
        if(repo.addProduct(p) > 0) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String updateProduct(Product p, int id) {
        if(repo.updateProduct(p, id) > 0) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String deleteProduct(int id) {
        if(repo.deleteProduct(id) > 0) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<Product> getProGroupByCategory(Category c) {
        return repo.getProGroupByCategory(c);
    }
    
}
