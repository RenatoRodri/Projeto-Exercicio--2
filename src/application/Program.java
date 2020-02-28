package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner ( System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" +i+ " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char result = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(result == 'i') {
				System.out.print("Customs fee: ");
				double impot = sc.nextDouble();
				list.add(new ImportedProduct(name, price, impot));
			}
			
			else if(result == 'c') {
				 list.add(new Product(name, price));
			}
			
			else if(result == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
		
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product c : list) {
			System.out.println(c.pricetag());
		}
		
		sc.close();

	}

}
