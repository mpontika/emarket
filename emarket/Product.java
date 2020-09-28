package emarket;
import java.util.Scanner;

public class Product {

	protected static Product[] products = new Product[20];
    private static int count = 0; //count created objects

    private static Scanner scanner= new Scanner (System.in);

	private int code;
	private String name;
	private double price;
	private int availability;

	public Product() {
	}

	public Product(String name, double price, int availability) {
		this.name = name;
		this.price = price;
		this.availability = availability;
		products[count]=this;//add object to the array
		code=count;//assign the current value of the static variable count to the id
		count++;//increase the number of created customers
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public static String getNameById(int pr) {
		return products[pr].getName();
	}

	public static double getPriceById(int pr) {
		return products[pr].getPrice();
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}


	public static void printAvailability(){
		for(int i=0;i<count; i++){
		  if(products[i].availability>0){
			  System.out.printf("Product [id=%d, name=%s, price=%.2f, available quantity=%d]\n", products[i].code, products[i].name, products[i].price, products[i].availability);
		  }
	  }
	}

	public static void printProducts(){
		for (int i=0; i<count; i++){
			System.out.printf("Product [id=%d, name=%s, price=%.2f, available quantity=%d]\n", products[i].code, products[i].name, products[i].price, products[i].availability);
		}
	}

   public static int[][] buyProduct(){

		int p_id;
		int counter=0;
		int[][] buyed_products = new int[20][2];
		System.out.print("Please select products. \n Press -1 to stop.\n Maximum number of items: 20\n\n");
	   do {
		   System.out.print("product_id:");
		   p_id =scanner.nextInt();
		   		if (p_id == -1) {
					break;
				}
			   while (p_id > 20 || products[p_id]==null){
					System.out.print("product_id doesn't exist.Please try again:");
					p_id =scanner.nextInt();
			   		if (p_id == -1) {
						break;
					}
				}
			   if (products[p_id].availability==0){
					System.out.print("Product " + products[p_id].getName() + " is not available\n");
				}
				if (products[p_id].availability > 0){
					System.out.print("quantity:");
		            int qnt =scanner.nextInt();
		               while (products[p_id].availability < qnt){
			              System.out.printf("Only %d items available ", products[p_id].availability);
			              System.out.print("please insert other quantity:");
			              qnt =scanner.nextInt();
		               }
		            products[p_id].availability = products[p_id].availability - qnt;
		            counter ++;
			        buyed_products[counter][0]=p_id;
			        buyed_products[counter][1]=qnt;
                }
	   } while (p_id != -1 || counter != 20);
	   //end of do/while

       return buyed_products;

   }//end of buy product

}
