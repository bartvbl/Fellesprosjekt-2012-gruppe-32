package fp.xmlConverters;

import java.io.IOException;
import java.text.ParseException;

import no.ntnu.fp.model.Person;
import nu.xom.Element;
import nu.xom.ParsingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import fp.dataObjects.User;

public class UserConverter {

	/*
	public static void main(String[] args) {
		User user = new User(123, "Neshyyy", "rumpeldunk", "Anders", "Bøe",
				"rofl@foobar.com", "22225555");
	}
	*/

	public static Element convertUserToXML(User user) {
		Element element = new Element("user");

		Element userID = new Element("userID");
		userID.appendChild(user.userID + "");
		
		Element userName = new Element("userName");
		userName.appendChild(user.userName +  "");

		Element password = new Element("password");
		password.appendChild(user.password);

		Element firstName = new Element("firstName");
		firstName.appendChild(user.firstName);

		Element lastName = new Element("lastName");
		lastName.appendChild(user.lastName);

		Element email = new Element("email");
		email.appendChild(user.email);

		Element phoneNumber = new Element("phoneNumber");
		phoneNumber.appendChild(user.phoneNumber);

		element.appendChild(userID);
		element.appendChild(userName);
		element.appendChild(firstName);
		element.appendChild(lastName);
		element.appendChild(password);
		element.appendChild(phoneNumber);
		element.appendChild(email);
		return element;
	}

	public static User toUser(String xml) throws java.io.IOException,
			java.text.ParseException, nu.xom.ParsingException {
		nu.xom.Document doc;
		try {
			nu.xom.Builder parser = new nu.xom.Builder(false);
			doc = parser.build(xml, "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return convertXMLToUser(doc.getRootElement());
	}

	public static User convertXMLToUser(Element userElement) {
		String userID = null, userName = null, password = null, firstName = null, lastName = null, email = null, phoneNumber = null;
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
		return new User(Integer.parseInt(userID), userName, password,
				firstName, lastName, email, phoneNumber);

	}

}
