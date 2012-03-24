package fp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHasher {
	private static MessageDigest messageDigest = null;
	
	public static String hashPassword(String password, String salt) {
		System.out.println("hashing " + password + " with salt " + salt);
		if(messageDigest == null){
			try {
				messageDigest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {e.printStackTrace();}
		}
		
		String hashString = password + salt;
		try {
			messageDigest.update(hashString.getBytes("UTF-16"));
		} catch (UnsupportedEncodingException e) {e.printStackTrace();}
		
		return new String(messageDigest.digest());
	}
	
}
