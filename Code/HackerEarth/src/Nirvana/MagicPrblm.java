/* IMPORTANT: class must not be public. */
package Nirvana;

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MagicPrblm {
	public static void main(String args[]) throws Exception {

		// * Read input from stdin and provide input before running

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"Nirvana")));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		for (int i = 0; i < N; i++) {
			int resultCounter= 0, count = 0;
			int result = Integer.parseInt(br.readLine());
			
			while((++resultCounter)*2 < result){
				count++;
				resultCounter *= 2;
			}
			
			while(resultCounter++ < result)
				count++;
			System.out.println(count);
		}
	}
}
