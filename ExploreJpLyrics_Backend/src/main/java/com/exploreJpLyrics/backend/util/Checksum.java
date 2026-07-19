package com.exploreJpLyrics.backend.util;

import java.math.BigInteger;

public class Checksum {

	private static final long DIVISOR = 37;
	private static final char[] ALPHABET = { '0', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', '*', '~', '$', '=', 'U' };

	public static int calculateChecksum(byte[] bytes) {
		BigInteger bigIntValue = new BigInteger(1, bytes);
		int checksum = bigIntValue.remainder(BigInteger.valueOf(DIVISOR)).intValue();
		return checksum;
	}

	public static char getChecksumCharacter(int checksumNum) {
		return ALPHABET[checksumNum];
	}

}