/* IMPORTANT: class must not be public. */
package MetricStream;

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SimpleTask {
	public static void main(String args[]) throws Exception {

		// * Read input from stdin and provide input before running

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"SimpleTask")));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
				
			List<Integer> stack = new ArrayList<Integer>();
			String[] stackString = br.readLine().split("\\s");
			for (int j = 0; j < stackString.length; j++) {
				stack.add(Integer.parseInt(stackString[j]));
			}

			Collections.sort(stack,Collections.reverseOrder());
			int minNum = stack.get(1);
			if(stack.get(0) != minNum)
				System.out.println(minNum*2+1);
			else
				System.out.println(minNum*2);

		}
	}
}
