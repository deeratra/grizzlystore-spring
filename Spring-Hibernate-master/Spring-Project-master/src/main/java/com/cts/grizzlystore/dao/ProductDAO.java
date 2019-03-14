package com.cts.grizzlystore.dao;

import java.util.List;

import com.cts.grizzlystore.bean.Product;


public interface ProductDAO {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public void deleteProduct(String productId);
	public List<Product> filterProducts(String query);
	public String updateProduct(Product product);
}
