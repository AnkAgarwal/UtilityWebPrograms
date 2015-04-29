import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
	static int countUneatenLeaves(int N, int[] A) {

		int[] leaves = new int[N + 1];
		for (int i = 1; i <= N; i++)
			leaves[i] = 1;

		for (int i = 0; i < A.length; i++) {
			if (leaves[A[i]] == 0)
				continue;
			for (int j = 1; j * A[i] <= N; j++) {
				leaves[A[i] * j] = 0;
			}
		}
		int count = 0;
		for (int i = 1; i <= N; i++)
			if (leaves[i] == 1)
				count++;
		return count;
	}

	public static void main(String[] args) {
		int N = 10;
		int[] A = new int[] { 2, 4, 5 };
		System.out.println(countUneatenLeaves(N, A));
	}
}