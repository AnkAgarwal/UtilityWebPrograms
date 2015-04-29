package com.sampleTest.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author Ankit 
 * contains the utility functions
 *
 */
public class Utility {

	// Generate the random number
	public static int getRandomNumer() {
		Random rn = new Random();
		return rn.nextInt();
	}

	// Use to provide the byte[] from the filepath
	public static byte[] readFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		// byte[] data = Files.readAllBytes(path);
		return Files.readAllBytes(path);
	}

	// Write the byte[] to the filepath provided
	public static void writeFile(String filePath, byte[] input)
			throws IOException {
		Path path = Paths.get(filePath);
		Files.write(path, input, StandardOpenOption.CREATE);
	}

	/*
	 * Calculate checksum of a File using MD5 algorithm
	 */
	public static String checkSum(byte[] input) {
		String checksum = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Using MessageDigest update() method to provide input
			md.update(input, 0, input.length);

			byte[] hash = md.digest();
			checksum = new BigInteger(1, hash).toString(16);
		} catch (NoSuchAlgorithmException ex) {

		}

		return checksum;
	}
}
