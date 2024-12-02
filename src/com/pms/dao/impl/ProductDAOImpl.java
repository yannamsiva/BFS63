package com.pms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pms.dao.ProductDAO;
import com.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {

	List<Product> addProducts = null;
	Scanner sc = new Scanner(System.in);

	@Override
	public void addProducts() {
		// TODO Auto-generated method stub
		addProducts=new ArrayList<>();
		int k = 1;
		while (k == 1) {
			System.out.println("Enter Product Id");
			int id = sc.nextInt();
			System.out.println("Enter Product Name");
			String name = sc.next();
			System.out.println("Enter Product Quanty");
			int qty = sc.nextInt();
			System.out.println("Enter Product Price");
			int price = sc.nextInt();
			Product p = new Product(id, name, qty, price);
			addProducts.add(p);

			System.out.println("Product added SuccessFully");
			System.out.println("Do You want to add one more record 1)Yes 2) No");
			k = sc.nextInt();
		}
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		return addProducts;
	}

	@Override
	public Product viewProduct(int pid) {
		// TODO Auto-generated method stub

		for (Product p : addProducts) {
			if (p != null)
				if (p.getPid() == pid) {
					return p;
				}
		}
		return null;
	}

	@Override
	public int updateProduct(int pid) {
		// TODO Auto-generated method stub

		int count = 0;
		for (Product p : addProducts) {
			if (p != null)
				if (p.getPid() == pid) {
					count++;
					System.out.println("Do you want to update 1)Pname 2)Qty 3)Price");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter Product name");
						p.setPname(sc.next());
						break;
					case 2:
						System.out.println("Enter Product Quantity");
						int qty = sc.nextInt();
						p.setQty(qty);
						break;
					case 3:
						System.out.println("Enter Produt price");
						p.setPrice(sc.nextInt());
						break;
					default:
						System.out.println("Choose 1 to 3 between");

					}// end of swith

				}

		} // end of for loop

		return count;
	}

	@Override
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub

		boolean flag = false;

		for (Product p : addProducts) {
			if (p != null)
				if (p.getPid() == pid) {
					addProducts.remove(p);
					flag = true;
					break;
				}

		}

		return flag;
	}

}
