/* IMPORTANT: class must not be public. */
package MetricStream;

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class CoinCollection {
	public static void main(String args[]) throws Exception {

		// * Read input from stdin and provide input before running

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"CoinCollection")));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("\\s");
			// int numStack = Integer.parseInt(input[0]);
			int maxHgt = Integer.parseInt(input[1]);
			List<Integer> stack = new ArrayList<Integer>();
			String[] stackString = br.readLine().split("\\s");
			for (int j = 0; j < stackString.length; j++) {
				stack.add(Integer.parseInt(stackString[j]));
			}

			int maxcoins = 0, BestResult = 0;
			for (int j = 0; j < stack.size(); j++) {
				if (stack.get(j) <= maxHgt) {
					maxcoins += stack.get(j);
				} else {
					if (BestResult < maxcoins) {
						BestResult = maxcoins;
					}
					maxcoins = 0;
				}
			}
			if (maxcoins > BestResult)
				BestResult = maxcoins;

			System.out.println(BestResult);

		}
	}
}
