package fp.xmlConverters;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import nu.xom.Element;
import fp.dataObjects.User;

public class UserConverter {

	public static void main(String[] args) {
		User user = new User(123, "Neshyyy", "rumpeldunk", "Anders", "Bøe",
				"rofl@foobar.com", "22225555");
		String userToXML = convertUserToXML(user);
		System.out.println(convertUserToXML(user));
		Element elem = convertXMLStringToElement(userToXML);
		User user2 = convertXMLToUser(elem);
		System.out.println(user2);

	}

	public static String convertUserToXML(User user) {
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
	
	public static Element convertXMLStringToElement(String xmlString){
		
		
	}

	public static User convertXMLToUser(Element userElement) {
		String userID = null, userName = null, password = null, firstName = null, lastName = null,
				email = null, phoneNumber = null;
		Element element = userElement.getFirstChildElement("userID");
		if (element != null) {
			userID = element.getValue();
		}
		element = userElement.getFirstChildElement("userName");
		if (element != null) {
			userName = element.getValue();
		}
		element = userElement.getFirstChildElement("password");
		if (element != null) {
			password = element.getValue();
		}
		element = userElement.getFirstChildElement("firstName");
		if (element != null) {
			firstName = element.getValue();
		}
		element = userElement.getFirstChildElement("lastName");
		if (element != null) {
			lastName = element.getValue();
		}
		element = userElement.getFirstChildElement("email");
		if (element != null) {
			email = element.getValue();
		}
		element = userElement.getFirstChildElement("phoneNumber");
		if (element != null) {
			phoneNumber = element.getValue();
		}
		return new User(Integer.parseInt(userID), userName, password, firstName, lastName, email, phoneNumber);
		
	}
}
