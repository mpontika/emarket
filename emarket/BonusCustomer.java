package emarket;
import java.util.Scanner;

public class BonusCustomer extends Customer {

	private Bonus card;

	private static Scanner scanner= new Scanner (System.in);

	public BonusCustomer(String fullname, String username, String password){
		super(fullname, username, password);
		this.card = new Bonus();
	}

	public Bonus getCard() {
		return card;
	}

    public void setCard(Bonus card) {
	   this.card = card;
	}

	@Override
	public void printMenu(){
				int choice=0;
				while (choice!=6){
					System.out.println();
					System.out.println("** MENU ** ");
					System.out.println("   1. Change password");
					System.out.println("   2. Print bonus points ");
					System.out.println("   3. Print available products ");
					System.out.println("   4. Buy products ");
					System.out.println("   5. Print previous transactions ");
					System.out.println("   6. Exit ");
			        System.out.print("   Make a choice: ");
			        choice = scanner.nextInt();
						if(choice==1)
							changePassword();
						else if (choice==2)
							card.printBonusPoints();
						else if (choice==3)
							Product.printAvailability();
						else if (choice==4) {
							int[][] b_products = Product.buyProduct();
							Receipt receipt = new Receipt(true, b_products);
							double totalcost = receipt.printReceipt();
							card.updateCardPoints(totalcost);
						} else if (choice==5)
			               Receipt.printPreviousTransactions(super.getId());
				}
		}

}