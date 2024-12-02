package com.pms.dao;

import java.util.List;

import com.pms.model.Product;

public interface ProductDAO {

	void addProducts();

	List<Product> viewAllProducts();

	Product viewProduct(int pid);

	int updateProduct(int pid);

	boolean deleteProduct(int pid);

}
