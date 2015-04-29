import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {
	static int yourMethod(int[] s) {
		
		int max=0;		
		int[] lis = new int[s.length];
		for (int index = 0; index < lis.length; index++) {
			lis[index] = 1;
		}
		
		for (int seqIndex = 1; seqIndex < s.length; seqIndex++) {
			for (int jprevIndex = 0; jprevIndex < seqIndex; jprevIndex++) {
				if( s[seqIndex] > s[jprevIndex] && lis[seqIndex] < lis[jprevIndex] + 1)
					lis[seqIndex] = lis[jprevIndex]+1;
			}			
		}
		
		for (int flagArrIndex = 0; flagArrIndex < lis.length; flagArrIndex++) {
			if(max< lis[flagArrIndex])
				max=lis[flagArrIndex];
		}
		return max;
	}

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int _a;
		_a = in.nextInt();
		int _b;
		_b = in.nextInt();*/
		int[] s = {2,3,3,5};
		System.out.println(yourMethod(s));
		
		int[] s1 = {1,4,5,2,6};
		System.out.println(yourMethod(s1));
	}
}