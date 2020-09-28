package emarket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {

	protected static Receipt [] receipts= new Receipt[20];//array to store the Receipts
	private static int count; //count created objects


    private int receipt_id;
    private int boughtItems;
    private boolean bonus_user;
    private Date date;
    private double totalcost;
    protected int [][] productinfo;

    public Receipt(boolean bonus_user, int[][] productinfo) {
		Date now = new Date();
		date=now;
		boughtItems = 0;
		this.productinfo = productinfo;
		this.totalcost=calculateTotalCost(productinfo);
		receipts[count]=this;//add object to the array
		count++;//increase the number of created customers
		receipt_id=count;//assign the current value of the static variable count to the id


    }

    public double getTotalCost() {
		return this.totalcost;
	}
	public int getBoughtItems(){
			return this.boughtItems;
	}

    public double printReceipt(){
		System.out.println("\nReceipt #" +receipt_id + "#\n" +
		                   "Date of issue: " + date.toString());  // dow mon dd hh:mm:ss zzz yyyy
                            int bought_items=0;
                            String name;
                            double price;
                            int quantity;
                            double totalprice;
		                    for(int i=0; i<productinfo.length; i++){
								if (productinfo[i][1] == 0) {
									continue;
								}
								name = Product.getNameById(productinfo[i][0]);
								price = Product.getPriceById(productinfo[i][0]);
								quantity = productinfo[i][1];
								totalprice = price*quantity;
								this.boughtItems = quantity + boughtItems;
								System.out.println("|"   +name+ "\t\t"        +price        +"|\n"+
								                   "|    x"+quantity+"\t\t"  +totalprice  + "|");
							}
	      System.out.println("Total cost:\t" + this.totalcost);
			return totalcost;

}

   private double calculateTotalCost(int[][] buyed_products){

	   double totalcost=0;
	   for(int i=0; i<buyed_products.length; i++){
		   double price = Product.getPriceById(buyed_products[i][0]);
		   int quantity = buyed_products[i][1];
		   double totalprice = price*quantity;
		   totalcost= totalcost + totalprice;
		}
		return totalcost;
   }

   public static void printPreviousTransactions(int id){
	   for(int i=0;i<receipts.length; i++){
		   if (receipts[i] == null){
			   break;
		   }
    		System.out.println("Date of issue:" + receipts[i].date.toString() + "\tTotal cost:" + receipts[i].getTotalCost() + "\tBought items:" + receipts[i].getBoughtItems() );
	}
   }
}





