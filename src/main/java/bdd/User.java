package bdd;

public class User {
	private String name;
	private String pass;
	private int id = 0;

	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public User() {
		
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
	
	public String getPass(){
		return pass;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}

	public boolean equals(Object u) {
		return name.equals(((User) u).name);
	}

	public String toString() {
		return id + ": " + name;
	}

}
