public class BoughtFood {
	int Id;
	int buyerId;
	boolean isNormal;
	public BoughtFood(int Id, int buyerId, boolean isNormal) {
		this.isNormal = isNormal;
		this.Id = Id;
		this.buyerId = buyerId;
	}
	public boolean isNormal() {
		return isNormal;
	}
	public void setNormal(boolean isNormal) {
		this.isNormal = isNormal;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String toString() {
		String output = this.Id + " " + this.buyerId;
		return output;
	}
}