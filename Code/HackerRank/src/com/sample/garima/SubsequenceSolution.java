package com.sample.garima;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubsequenceSolution {
	static int yourMethod(String input) {

		int maxValToReturn = 1;

		String[] inpArr = input.split("\\s");
		for (int j = 0; j < inpArr.length; j++) {
			int valToReturn = 1;
			int valToCompare = Integer.parseInt(inpArr[j]);
			for (int i = j + 1; i < inpArr.length; i++) {
				if (Integer.parseInt(inpArr[i]) > valToCompare) {
					valToReturn++;
					valToCompare = Integer.parseInt(inpArr[i]);
				}
			}
			if (maxValToReturn < valToReturn)
				maxValToReturn = valToReturn;
		}

		return maxValToReturn;
	}

	public static void main(String[] args) {
		String input = "";
		/*
		 * String input = "1 2 3 4 5 6 7";
		 * System.out.println(yourMethod(input));
		 */

		input = "1 4 3";
		System.out.println(yourMethod(input));

		input = "1 4 5 2 5";
		System.out.println(yourMethod(input));

		input = "2 4 4 5";
		System.out.println(yourMethod(input));

		input = "10 9 5 6 9 10 12";
		System.out.println(yourMethod(input));
	}
}