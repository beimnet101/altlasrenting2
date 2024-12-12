package repository;
import org.springframework.data.jpa.repository.JpaRepository;

import model.ProductCategory;



public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    // Additional methods, if needed
}
