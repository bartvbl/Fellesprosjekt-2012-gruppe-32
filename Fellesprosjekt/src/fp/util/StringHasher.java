package fp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringEscapeUtils;

import nu.xom.Element;

public class StringHasher {
	private static MessageDigest messageDigest = null;
	
	public static String hashPassword(String password, String salt) {
		if(messageDigest == null){
			try {
				messageDigest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {e.printStackTrace();}
		}
		
		String hashString = password + salt;
		try {
			messageDigest.update(hashString.getBytes("US-ASCII"));
		} catch (UnsupportedEncodingException e) {e.printStackTrace();}
		byte[] stringBytes = messageDigest.digest();
		char[] charSequence = new char[stringBytes.length];
		for(int i = 0; i < stringBytes.length; i++) {
			int byteValue = stringBytes[i];
			byteValue = byteValue % 26;
			byteValue += 97;
			charSequence[i] = (char) byteValue;
		}
		String hashedString = new String(charSequence);
		String escapedString = StringEscapeUtils.escapeXml(hashedString);
		return escapedString;
	}
	
}
