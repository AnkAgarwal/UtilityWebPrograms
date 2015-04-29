package couponDunia;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Prblm2 {
	static void yourMethod(int[] prices) {
		int buyIndex = 0;
		int sellIndex = 1;
		int difference = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				difference = prices[sellIndex] - prices[buyIndex];
				if ((prices[j] - prices[i]) > difference) {
					buyIndex = i;
					sellIndex = j;
				}
			}
		}
		System.out.println(buyIndex + 1 + " " + prices[buyIndex]);
		System.out.println(sellIndex + 1 + " " + prices[sellIndex]);
	}

	public static void main(String[] args) {

		int[] a = { 70, 72, 73, 78, 79, 74, 77 };
		yourMethod(a);
	}
}