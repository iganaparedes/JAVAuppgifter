package uppgift2;

public class LoginBean {
	
	
	private String name, password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateOne () {
		if(password.equals("banana")) {
			return true;
		}
		return false;
	}
	
	public boolean validateTwo () {
		if(password.equals("woof")) {
			return true;
		}
		return false;
	}

}
