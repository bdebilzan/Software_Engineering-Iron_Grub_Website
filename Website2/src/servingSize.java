public class servingSize {
    
    int Id;
    String foodName;
    String size;
    double calories;
    double protein;
    double fat;
    double carbs;
    int pickFoodId;
    public servingSize(int Id, String foodName, String size, double calories, double protein, double fat, double carbs, int pickFoodId) {
    	this.Id = Id;
    	this.foodName = foodName;
    	this.size = size;
    	this.calories = calories;
    	this.protein = protein;
    	this.fat = fat;
    	this.carbs = carbs;
    	this.pickFoodId = pickFoodId;
    }
	public int getPickFoodId() {
		return pickFoodId;
	}
	public void setPickFoodId(int pickFoodId) {
		this.pickFoodId = pickFoodId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
    public String toString() {
    	return  foodName + " " + calories ;
    }
   
}