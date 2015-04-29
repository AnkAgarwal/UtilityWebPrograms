package com.sample.garima;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeavesSolution {

	public static void main(String[] args) {

		int numOfLeave = 10;
		int numOfCaterpillar = 3;
		int[] caterpillarJump = new int[]{2,4,5};			
		
		System.out.println(yourMethod(numOfLeave, numOfCaterpillar, caterpillarJump));
	}

	
	private static int yourMethod(int numOfLeave, int numOfCaterpillar, int[] caterpillarJump) {
		Set<Integer> eatenLeavesSet=new HashSet<Integer>();
		
		for (int i = 0; i < caterpillarJump.length; i++) {
			for (int j = caterpillarJump[i]; j <= numOfLeave; j++) {
				if(j%caterpillarJump[i] == 0)
					eatenLeavesSet.add(j);
			}
		}
		return numOfLeave-eatenLeavesSet.size();
	}
}