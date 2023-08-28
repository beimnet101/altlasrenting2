package repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByRentalOwnerId(Long rentalOwnerId);
        List<Product> findByCategory(String category);

        List<Product> findByTitleContainingIgnoreCase(String keyword);
    }
