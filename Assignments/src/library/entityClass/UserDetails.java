package library.entityClass;

public class UserDetails {

	private int userId;
	private String userName;
	private String role;
	private String contactNumber;
	String password;
	
	public UserDetails(int userId,String userName,String role,String contactNumber,String password) {
		this.userId=userId;
		this.userName=userName;
		this.role=role;
		this.contactNumber=contactNumber;
		this.password=password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
