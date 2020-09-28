package emarket;
import java.util.Scanner;

public class Customer {

	protected static Customer [] customers= new Customer[20];//array to store the Customers (and BpnusCustomers as the storage takes place in the constructor)
	private static int count; //count created objects

	private static Scanner scanner= new Scanner (System.in);

    private int id;
    private String fullname;
	private String username;
	private String password;



	public Customer(String fullname, String username, String password) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		customers[count]=this;//add object to the array
		count++;//increase the number of created customers
		id=count;//assign the current value of the static variable count to the id


	}


	public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public int getId() {
			return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    //search Customers by name and password
	public static Customer searchCustomer(String username, String password) {
			for(int i=0;i<customers.length; i++){//search the customer array
				if (customers[i]!=null){//if a customer exists in the specific position [i]
					if(customers[i].username.equals(username) && customers[i].password.equals(password)){//compare name and password of the customer in position [i] with the given name and password
						return customers[i];//return customer
					}
				}
			}
			return null;//no customer was not found the given name (argument)
	}

		public void printMenu(){

			int choice=0;
			while (choice != 4){
				System.out.println();
				System.out.println("** MENU ** ");
				System.out.println("   1. Change password");
				System.out.println("   2. Print products ");
			    System.out.println("   3. Buy products ");
			    System.out.println("   4. Exit ");
			    System.out.print("   Make a choice: ");
			    choice = scanner.nextInt();
					if(choice==1)
						changePassword();
					else if (choice==2)
						Product.printProducts();
					else if (choice==3) {
						int[][] b_products = Product.buyProduct();
						Receipt receipt = new Receipt(false, b_products);
						double totalcost = receipt.printReceipt();
					}
			}
	}
	//change Customers password
	public  void changePassword() {
					scanner.nextLine();
					System.out.println("** Change Password ** ");
					System.out.print("type new password: ");
					String new_pas = scanner.nextLine();
				    System.out.print("type it again: ");
				    String rep_pas = scanner.nextLine();
				    if (new_pas.equals(rep_pas)){
						setPassword(rep_pas);
						System.out.println("Password has been changed");
					} else {
						System.out.println("Passwords don't match");
					}

	}

}
