public class BFood{
	int id;
	int amountBought;
	public BFood(int id , int amountBought) {
		this.id =id;
		this.amountBought = amountBought;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmountBought() {
		return amountBought;
	}
	public void setAmountBought(int amountBought) {
		this.amountBought = amountBought;
	}
	public String toString() {
		return id + " " + amountBought;
	}
}