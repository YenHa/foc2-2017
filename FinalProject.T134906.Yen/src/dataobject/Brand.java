package dataobject;

public class Brand {
	private int id;
	private String name;
	private String brandDescription;
	
	public Brand(){}
	public Brand(int id, String name,String brandDescription) {
		super();
		this.id = id;
		this.name = name;
		this.brandDescription = brandDescription;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	
	@Override
	public String toString() {
		return name + brandDescription ;
	}

	
	
}