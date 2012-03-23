package fp.util;

import java.util.Random;

public class RandomStringGenerator {
	private static final int charNumberLowerBound = 32;
	private static final int charNumberUpperBound = 126;
	
	public static String generateString() {
		Random random = new Random(System.nanoTime());
		char[] characterList = new char[32];
		for(int i = 0; i < 32; i++) {
			characterList[i] = getRandomCharacter(random);
		}
		return new String(characterList);
	}

	private static char getRandomCharacter(Random random) {
		int randomInt = random.nextInt(charNumberUpperBound - charNumberLowerBound);
		randomInt += charNumberLowerBound;
		return (char) randomInt;
	}
}
