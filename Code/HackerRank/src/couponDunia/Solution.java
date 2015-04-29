package couponDunia;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static void yourMethod(String[] baby_words, String garbled_text) {
		StringBuffer result = new StringBuffer();
		List<String> wordsBaby = Arrays.asList(baby_words);
		Collections.sort(wordsBaby, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		});
		
		for (int i = 0; i < garbled_text.length(); i++) {
			for (int j = 0; j < wordsBaby.size(); j++) {
				
				String babyWord = wordsBaby.get(j);
				int babyWordSize = babyWord.length();
				if(garbled_text.substring(i, i+babyWordSize).equals(babyWord)){
					result.append(babyWord);
					result.append(" ");
					i = i+babyWordSize-1;
					j=0;
					break;
				}
			}
		}
		System.out.println(result);
		

	}

	

	public static void main(String[] args) {
		String[] baby_words = { "gag", "goo", "gaga" };
		String garbled_text = "gagagoogoo";
		yourMethod(baby_words, garbled_text);

		/*
		 * String[] baby_words = {"ogoo","pgo","gaga"}; String garbled_text =
		 * "gagaogoogoo";
		 */
	}

	
}