package fp.utils;

import java.util.Random;

public class StringRandomiser {
	public static String generateRandomString() {
		Random randomGenerator = new Random(328223738);
		startupGenerator(randomGenerator);
		byte[] byteArray = new byte[32];
		randomGenerator.nextBytes(byteArray);
		String output = new String(byteArray);
		System.out.println(output);
		return output;
	}

	private static void startupGenerator(Random randomGenerator) {
		randomGenerator.nextInt();
	}
}
