package emarket;

public class Bonus {


	private int cardpoints;

	public Bonus (){
		this.cardpoints= 0;
	}

	public long getCardpoints() {
		return cardpoints;
			}

	public void setCardpoints(int cardpoints) {
		this.cardpoints = cardpoints;
	}

    public void updateCardPoints(double payment){
		cardpoints = (int)(payment/3) + cardpoints;
		if (cardpoints >= 200){
			System.out.println("Congratulations, you completed 200 bonus points! A 20% discount is yours!");
			cardpoints = cardpoints - 200;
		}
	}

	public void printBonusPoints() {
		int c = 200-cardpoints;
		System.out.println("You have " + cardpoints + " you need "+ c +" to take 20% discount");
	}


}