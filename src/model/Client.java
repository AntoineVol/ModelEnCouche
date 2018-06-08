package model;

public class Client {
	private int id;
	private String name;
	
	//BUILDER
	public Client() {
		
	}
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
	//GETTER & SETTER
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
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	
}
