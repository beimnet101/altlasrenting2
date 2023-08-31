package controller;
import service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Product;
import service.ProductCategoryService;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // ...

    @PostMapping("/upload/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    // ...

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
        
    }
        
       
          @GetMapping("/{productId}")
            public ResponseEntity<Product>getProductById(@PathVariable Long productId) {
                Product product = productService.getProductById(productId);
                if (product == null) {
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(product);
            }

            @GetMapping("/filter")
            public ResponseEntity<List<Product>> filterProducts(@RequestParam("category") String category) {
                List<Product> filteredProducts = productService.getProductsByCategory(category);
                return ResponseEntity.ok(filteredProducts);
            }

            @GetMapping("/search")
            public ResponseEntity<List<Product>> searchProducts(@RequestParam("keyword") String keyword) {
                List<Product> searchedProducts = productService.searchProducts(keyword);
                return ResponseEntity.ok(searchedProducts);
            }

            @GetMapping("/all")
            public ResponseEntity<List<Product>> getAllProducts() {
                List<Product> allProducts = productService.getAllProducts();
                return ResponseEntity.ok(allProducts);
            }

            
               @GetMapping("/renterside/search")
                public ResponseEntity<List<Product>> searchProduct(
                       @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "category", required = false) String category) {
                    List<Product> products = productService.searchProducts(name, category);
                    if (!products.isEmpty()) {
                        return ResponseEntity.ok(products);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }
            
            
            
}
           
        
    