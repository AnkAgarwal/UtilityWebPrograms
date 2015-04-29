/* IMPORTANT: class must not be public. */
package MetricStream;

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class PalindromeColection {
	public static void main(String args[]) throws Exception {

		// * Read input from stdin and provide input before running

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"PalindromeColection")));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			try{
				System.out.println((int)((Math.pow(26,Math.ceil(input/2.0))) % (Math.pow(10, 9) + 9)));
			}catch(Exception e){
				System.out.println("0");
			}
			
			
		}

	}

	
}
