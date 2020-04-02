package Model;

public abstract class Animal {
	private String Name;

	public Animal(String name) {
		Name = name;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
