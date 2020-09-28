package emarket;

import java.util.Scanner;

public class Emarket {

	public static void main(String[] args) {

		createObjects();//load objects to test functionality
		System.out.println("--- DMST SUPERMARKET ---");
		System.out.println("Log in to continue");
		Scanner scanner= new Scanner(System.in);
		Customer customer=null;

		do{//try to connect
			System.out.print("username: ");
			String username=scanner.nextLine();
			System.out.print("password: ");
			String password=scanner.nextLine();
			customer = Customer.searchCustomer(username,password);
			if(customer==null){//no customer is found with the specific name
				System.out.println("Wrong combination. Try again");
			}
			else if (customer instanceof BonusCustomer){//customer was found, check if it is BonusCustomer
				BonusCustomer bonusCustomer=(BonusCustomer)customer;//cast customer object to Bonuscustomer object
				bonusCustomer.printMenu();//print the bonusCustomer menu
			} else {
				customer.printMenu();//if is not bonusCustomer it is just Customer
			}
		} while (customer==null); //while no customer is found with the provided name
	}


	private static void createObjects(){
		Customer cst1=new Customer("Martha Pontika", "mpontika", "1234");
		BonusCustomer cst2=new BonusCustomer("Alkis", "al", "2345");
		Product pr1 = new Product("Milko", 1.30, 10);
		Product pr2 = new Product("Sugar", 2.40, 3);
		Product pr3 = new Product("Apples", 5.70, 50);
		Product pr4 = new Product("Coffee", 7.00, 0);
		Product pr5 = new Product("Always", 5.20, 1);
		Product pr6 = new Product("Car", 600.20, 2);
	}
}
