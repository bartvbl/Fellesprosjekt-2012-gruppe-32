package fp.dataObjects;

public class User {
	
	public final int userID;
	public final String userName;
	public final String password;
	public final String firstName;
	public final String lastName;
	public final String email;
	public final String phoneNumber;
	
	public User(int userID, String userName, String password,
			String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	

}
