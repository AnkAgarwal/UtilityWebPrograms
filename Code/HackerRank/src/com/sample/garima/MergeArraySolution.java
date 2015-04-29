package com.sample.garima;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeArraySolution {

	public static void main(String[] args) {

		int n = 5;
		int[] arr1 = new int[2 * n];
		int[] arr2 = new int[2 * n];

		arr1[0]=3;
		arr1[1]=14;
		arr1[2]=18;
		arr1[3]=20;
		arr1[4]=22;
		
		arr2[0]=13;
		arr2[1]=14;
		arr2[2]=16;
		arr2[3]=20;
		arr2[4]=25;

		printArr(arr1);
		printArr(arr2);
		printArr(yourMethod(arr1, arr2, n));
		//printArr(arr1);

	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}

	private static int[] yourMethod(int[] a, int[] b, int M) {
		int aIndex = M - 1;
		int bIndex = M - 1;
		int mergeIndex= (2*M)-1;
		while(aIndex >= 0 && bIndex >= 0){
			if (a[aIndex] >= b[bIndex]) {
				a[mergeIndex--] = a[aIndex--];
				/*arr1[i] = arr1[arr1Index];
				arr1Index--;
				i--;*/
			} else {
				a[mergeIndex--] = b[bIndex--];
				/*arr1[i] = arr2[arr2Index];
				arr2Index--;
				i--;*/
			}
		}
		
		while(aIndex >=0){
			a[mergeIndex--] = a[aIndex--];
			/*arr1[i] = arr1[arr1Index];
			i--;arr1Index--;*/
		}
		
		while(bIndex >=0){
			a[mergeIndex--] = b[bIndex--];
			/*arr1[i] = arr2[arr2Index];
			i--;arr2Index--;*/
		}
		return a;
	}
}