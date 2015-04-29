/* IMPORTANT: class must not be public. */
package Nirvana;

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

class BalancedString {
	public static void main(String args[]) throws Exception {

		// * Read input from stdin and provide input before running

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"BalanceString")));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		for (int j = 0; j < N; j++) {
			String arr = br.readLine();
			//String[] arr = s.toCharArray();
			Map<Character, Integer> myMap = new HashMap<Character, Integer>();
			int invalidCounter = 0;
			for (int i = 0; i < arr.length(); i++) {
				if(myMap.get(arr.charAt(i)) == null){
					myMap.put(arr.charAt(i), 1);
					invalidCounter++;
				}
				else{
					int val = (Integer) myMap.get(arr.charAt(i));
					myMap.put(arr.charAt(i), val+1);
					if((val + 1)%2 == 0)
						invalidCounter--;
					else
						invalidCounter++;
				}
			}
			if (invalidCounter == 0)
				System.out.println(1);
			else
				System.out.println(-1);
		}
	}
}
