package com.pms.client;

import java.util.Scanner;

import com.pms.details.ProductDetails;

public class ProductClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====================================================");
			System.out.println("               1)Login                           ");
			System.out.println("               2)LogOut                           ");
			System.out.println("=====================================================");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter UserName");
				String uname = sc.next();
				System.out.println("Enter Password");
				String pass = sc.next();
				if (uname.equals("admin") && pass.equals("admin@123")) {
					ProductDetails details = new ProductDetails();
					details.productMenu();
				} else {
					System.out.println("Invalid UserName and Password");
				}
				break;
			case 2:
				System.out.println("Thx for Using app!");
				System.exit(0);
			default:
				System.out.println("Choose 1 to 2 between");

			}// end of switch

		}

	}

}
