package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ProductCategory;

import repository.ProductCategoryRepository;
import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {

    	this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory updateProductCategory(Long id, ProductCategory productCategory) {
        ProductCategory existingCategory = productCategoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(productCategory.getName());
            // Set other properties as needed
            return productCategoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}