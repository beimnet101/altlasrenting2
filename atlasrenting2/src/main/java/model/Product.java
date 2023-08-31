package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "products")
	public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productId;

	    @Column(nullable = false)
	    private String name;
	    
	       @ManyToOne
	        @JoinColumn(name = "category")
	        private ProductCategory category;

	        // Constructors, getters, and setters

	        // ...
	    

	    // Other fields and methods specific to products

	    // Getters and Setters
	
	        private LocalDate isAvailableFrom;
	        private LocalDate isAvailableTo;
	        private BigDecimal pricePerDay;
	        private boolean isAvailable;

	      
	       

	        public void setIsAvailableFrom(LocalDate isAvailableFrom) {
	            this.isAvailableFrom = isAvailableFrom;
	        }

	        public LocalDate getIsAvailableTo() {
	            return isAvailableTo;
	        }

	        public void setIsAvailableTo(LocalDate isAvailableTo) {
	            this.isAvailableTo = isAvailableTo;
	        }

	        public BigDecimal getPricePerDay() {
	            return pricePerDay;
	        }

	        public void setPricePerDay(BigDecimal pricePerDay) {
	            this.pricePerDay = pricePerDay;
	        }

	        public boolean isAvailable() {
	            return isAvailable;
	        }

	        public void setAvailable(boolean available) {
	            isAvailable = available;}

			public LocalDate getIsAvailableFrom() {
				// TODO Auto-generated method stub
				return isAvailableFrom;
			}
}
