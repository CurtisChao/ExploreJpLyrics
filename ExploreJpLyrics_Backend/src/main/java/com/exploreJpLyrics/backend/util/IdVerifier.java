package com.exploreJpLyrics.backend.util;

import java.math.BigInteger;

import com.msiops.ground.crockford32.Crockford32;

public class IdVerifier {

	public static boolean verifyId(String identifier) {
		String idValue = identifier.substring(0, identifier.length() - 1);
		char checksumChar = identifier.charAt(identifier.length() - 1);

		BigInteger idBigIntValue = Crockford32.decode(idValue);
		byte[] idValueBytes = idBigIntValue.toByteArray();

		int calculatedChecksumInt = Checksum.calculateChecksum(idValueBytes);
		int calculatedChecksumChar = Checksum.getChecksumCharacter(calculatedChecksumInt);

		return checksumChar == calculatedChecksumChar;
	}

}
