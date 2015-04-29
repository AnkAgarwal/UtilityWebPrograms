package couponDunia;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Prblm1 {
	static String yourMethod(String str) {
		StringBuffer result = new StringBuffer();
		boolean flagSet = false;
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			char charToCompare = str.charAt(i);
			
			flagSet = false;
			counter = 0;
			for (int j = i; j < str.length(); j++) {
				
				if(charToCompare == str.charAt(j))
					counter++;
				else if (counter > 3){
					result.append(counter);
					result.append("@");					
					i = j-1;
					flagSet = true;
					break;
				}else
					break;				
			}
			if (flagSet == false && counter > 3) {
				result.append(counter);
				result.append("@");
				result.append(charToCompare);
				break;
			}
			result.append(charToCompare);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(yourMethod("aaaa"));
	}
}