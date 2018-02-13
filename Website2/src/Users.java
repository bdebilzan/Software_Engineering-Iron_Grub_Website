public class Users {
	int Id;
	String Name;
	String eMail;
	String address;
	
	public Users(int Id, String Name, String eMail, String address){	
		this.Id= Id;
		this.Name = Name;
		this.eMail = eMail;
		this.address = address;
			
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String toString(){
		return Id  + " " + Name;
	}
}