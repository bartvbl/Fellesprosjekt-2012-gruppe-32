package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.User;

public class UserConverter {
	
	
	public static void main(String[] args){
		User user = new User(123, "Neshyyy", "rumpeldunk", "Anders", "Bøe", "rofl@foobar.com", "22225555");
		
		System.out.println(convertPersonToXML(user));
		
	}
	
	public static String convertPersonToXML(User user) {
		Element element = new Element("user");
		
		Element userID = new Element("userID");
		userID.appendChild(user.userID + "");
		
		Element firstName = new Element("firstName");
		firstName.appendChild(user.firstName);
		
		Element lastName = new Element("lastName");
		lastName.appendChild(user.lastName);
		
		Element password = new Element("password");
		password.appendChild(user.password);
		
		Element phoneNumber = new Element("phoneNumber");
		phoneNumber.appendChild(user.phoneNumber);
		
		Element email = new Element("email");
		email.appendChild(user.email);
		
		
		element.appendChild(userID);
		element.appendChild(firstName);
		element.appendChild(lastName);
		element.appendChild(password);
		element.appendChild(phoneNumber);
		element.appendChild(email);
		return element.toXML();
	}

	// public static Person convertXMLToPerson(String xml) {
	//
	// }
}
