import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
	static int countUneatenLeaves(int N, int[] A) {

		// Set is used so that if 2 caterpillar are getting same leave, only 1
		// entry remains.
		Set<Integer> leavesEatenSet = new HashSet<Integer>();

		for (int index = 0; index < A.length; index++) {
			
			if(leavesEatenSet.contains(A[index]))
				continue;
			
			int incrementCounter = 2;
			int caterpillar = A[index];
			int nextLeaveIndex = caterpillar;
			// Traversed to get the leave visited by the caterpillar
			while (nextLeaveIndex <= N) {
				leavesEatenSet.add(nextLeaveIndex);
				nextLeaveIndex = caterpillar * incrementCounter++;

			}
		}

		// return the number of leaves uneaten
		return N - leavesEatenSet.size();

	}

	public static void main(String[] args) {
		int N = 10;
		int[] A = new int[] { 2, 4, 5 };
		System.out.println(countUneatenLeaves(N, A));
	}
}