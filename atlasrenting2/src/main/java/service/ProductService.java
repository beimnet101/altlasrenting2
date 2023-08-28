package service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Product;
import repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProductsByRentalOwnerId(Long rentalOwnerId) {
        return productRepository.findByRentalOwnerId(rentalOwnerId);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public boolean isAvailableFromSelectedDate(Long productId, LocalDate selectedDate) {
        Product product = getProductById(productId);
        if (product != null) {
            LocalDate availableFrom = product.getIsAvailableFrom();
            return availableFrom != null && !selectedDate.isBefore(availableFrom);
        }
        return false;
    }

    @SuppressWarnings("deprecation")
	public BigDecimal calculateRentPerDay(Long productId) {
        Product product = getProductById(productId);
        if (product != null) {
            if (product.isAvailable()) {
                LocalDate availableFrom = product.getIsAvailableFrom();
                LocalDate availableTo = product.getIsAvailableTo();
                if (availableFrom != null && availableTo != null && availableTo.isAfter(availableFrom)) {
                    long days = availableFrom.until(availableTo).getDays();
                    BigDecimal totalPrice = product.getPricePerDay().multiply(BigDecimal.valueOf(days));
                    return totalPrice.divide(BigDecimal.valueOf(days), 2, BigDecimal.ROUND_HALF_UP);
                }
            }
        }
        return BigDecimal.ZERO;
    }

	public void deleteProductsByRentalOwnerId(Long roleId) {
		// TODO Auto-generated method stub
		
	}

	  public List<Product> getProductsByCategory(String category) {
		        return productRepository.findByCategory(category);
		    }

    public List<Product> searchProducts(String keyword) {
		        return productRepository.findByTitleContainingIgnoreCase(keyword);
		    }

   public List<Product> getAllProducts() {
		        return (List<Product>) productRepository.findAll();
		    }

		    // Other product-related methods

		
		
		
	}


