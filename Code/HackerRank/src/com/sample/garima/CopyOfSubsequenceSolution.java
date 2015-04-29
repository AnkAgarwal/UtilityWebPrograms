package com.sample.garima;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CopyOfSubsequenceSolution {
	static int yourMethod(String input) {
		String[] inpArr = input.split("\\s");
		int max=0;
		
		int[] s = new int[inpArr.length];
		int[] lis = new int[inpArr.length];
		for (int i = 0; i < s.length; i++) {
			s[i]= Integer.parseInt(inpArr[i]);
			lis[i] = 1;
		}
		
		for (int i = 1; i < inpArr.length; i++) {
			for (int j = 0; j < i; j++) {
				if( s[i] > s[j])
					lis[i] = lis[j]+1;
			}			
		}
		
		for (int i = 0; i < lis.length; i++) {
			if(max< lis[i])
				max=lis[i];
		}
		return max;
		
		
	}

	public static void main(String[] args) {
		String input = "";

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