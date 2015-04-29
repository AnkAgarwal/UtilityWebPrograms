package porter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new FileReader(new File(
				"Porter1")));
		String line = br.readLine();
		String[] arrInput = line.split("\\s");
		int numberOfQueries = Integer.parseInt(arrInput[1]);
		//int arrsize = Integer.parseInt(arrInput[0]);
		//int[] input= new int[arrsize];
		String[] arrayElemtns = br.readLine().split("\\s");
		/*for(int i=0;i<arrsize;i++){
			input[i] = Integer.parseInt(arrayElemtns[i]);
		}*/
		
		int result=0;
		for (int j = 0; j < numberOfQueries; j++) {
			String[] queryElemts = br.readLine().split("\\s");
			int l =  Integer.parseInt(queryElemts[0]);
			int r =  Integer.parseInt(queryElemts[1]);
			int k =  Integer.parseInt(queryElemts[2]);
			 result=0;
			for (int i = l-1; i <= r-1; i= i+k) {
				result += Integer.parseInt(arrayElemtns[i]);
			}
			System.out.println(result);
			
		}
	}

}
