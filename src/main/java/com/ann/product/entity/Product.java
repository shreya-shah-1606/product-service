package com.ann.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCTS")
public class Product {
	
    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name="PRODUCT_TITLE")
    private String productTitle;
    
    @Column(name="PRODUCT_IMAGE")
    private String productImage;

    @Column(name = "PRODUCT_PRICE")
    private int productPrice;

    @Column(name = "PRODUCT_RATING")
    private int productRating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}


    
    

}
