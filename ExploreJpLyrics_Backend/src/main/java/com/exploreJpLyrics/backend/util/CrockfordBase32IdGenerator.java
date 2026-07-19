package com.exploreJpLyrics.backend.util;

import java.math.BigInteger;

import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;

import com.msiops.ground.crockford32.Crockford32;

@Component
public class CrockfordBase32IdGenerator {

	private BytesKeyGenerator bytesKeyGenerator = KeyGenerators.secureRandom();

	public String generateId() {
		byte[] bytes = bytesKeyGenerator.generateKey();
		BigInteger bigInt = new BigInteger(1, bytes); // Convert bytes to BigInteger
		return Crockford32.encode(bigInt);
	}

	public String generateIdWithChecksum() {
		byte[] bytes = bytesKeyGenerator.generateKey();
		int checksum = Checksum.calculateChecksum(bytes);
		char checksumCharacter = Checksum.getChecksumCharacter(checksum);

		BigInteger bigInt = new BigInteger(1, bytes);
		String crockford32Id = Crockford32.encode(bigInt);

		return crockford32Id + checksumCharacter;
	}

}
