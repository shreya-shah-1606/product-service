package com.ann.product.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ann.product.entity.Product;
import com.ann.product.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

	@Autowired
	ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get Products", description = "Get Products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public String getAllOrders(HttpServletRequest request, HttpServletResponse response) {
		String res = null;
		ObjectMapper Obj = new ObjectMapper();
		logger.info("Getting all products from Controller");
		List<Product> products = productService.getAllProducts();
		response.setStatus(200);
		try {
			res = Obj.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "addProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Add Product", description = "Add Product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Bad Request") })
	public Product addEBook(@RequestBody @Valid Product product, HttpServletRequest request, HttpServletResponse response) {
		return productService.saveProduct(product);
	}
}
