package com.pms.details;

import java.util.List;
import java.util.Scanner;

import com.pms.client.ProductClient;
import com.pms.dao.ProductDAO;
import com.pms.dao.impl.ProductDAOImpl;
import com.pms.model.Product;

public class ProductDetails {

	Scanner sc = new Scanner(System.in);
	ProductDAO daoImpl = new ProductDAOImpl();

	public void productMenu() {

		System.out.println("=====================================================");
		System.out.println("               1)AddProduct                           ");
		System.out.println("               2)ViewAllProducts                           ");
		System.out.println("               3)viewProduct                           ");
		System.out.println("               4)updateProduct                           ");
		System.out.println("               5)deleteProduct                           ");
		System.out.println("               6)Back                           ");

		System.out.println("=====================================================");

		System.out.println("Enter the choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			daoImpl.addProducts();
			productMenu();
			break;
		case 2:
			List<Product> viewAllProducts = daoImpl.viewAllProducts();

			int k=0;
			
			if (viewAllProducts != null)
			{
				
				for (Product p : viewAllProducts) {
					System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice() + "\t" + p.getQty());

				} // end of product
			}//end of if
			else
				System.out.println("Stock is empty");
			productMenu();
			break;
		case 3:
			System.out.println("Enter Product Id");
			Product p = daoImpl.viewProduct(sc.nextInt());
			if (p != null) {
				System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice() + "\t" + p.getQty());
			} else {
				System.out.println("Prouct Id doest Not exist");
			}
			productMenu();
			break;

		case 4:
			System.out.println("Enter Product Id");
			int count = daoImpl.updateProduct(sc.nextInt());
			if (count != 0)
				System.out.println("Data Updated Successfully");
			else
				System.out.println("Data not Updated Successfully");
			productMenu();
			break;
		case 5:
			System.out.println("Enter Product Id");
			boolean flag = daoImpl.deleteProduct(sc.nextInt());
			if (flag)
				System.out.println("Data deleted successfully");
			else
				System.out.println("Data not deleted successfully");
			productMenu();
			break;

		case 6:
			ProductClient.main(null);
			break;
		default:
			System.out.println("Choose 1 to 6 Between");

		}// end of switch

	}// end of product

}
