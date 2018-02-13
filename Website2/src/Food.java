//DONE
public class Food {
	int Id;
	String Name;
	String Image;
	String Description;
	double Price;
	boolean isSize;
	public Food( int Id, String name,String Image, String Description,double Price, boolean isSize) {
		this.Id = Id;
		this.Name = name;
		this.Image = Image;
		this.Description = Description;
		this.Price = Price;
		this.isSize = isSize;
	}
	public double getPrice() {
		return Price;
	}
	public boolean isSize() {
		return isSize;
	}
	public void setSize(boolean isSize) {
		this.isSize = isSize;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String toString() {
		String output ="Food ID : "  + this.Id + " Name: " + this.Name + "\nImage: " + this.Image + "\n" + "info: "+ this.Description;
		return output;
	}
	
}