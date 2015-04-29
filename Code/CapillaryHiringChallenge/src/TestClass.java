/* IMPORTANT: class must not be public. */

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


class TestClass {
    public static void main(String args[] ) throws Exception {
        
        //* Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new FileReader(new File("Data")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	int result=0;
        	String[] splitStar = br.readLine().split("\\*");
        	
        	for (int j = 0; j < splitStar.length; j++) {
        		String s=splitStar[j];
        		if(s.contains("X")==false && s.contains("O")){
        			result +=s.length() - s.replace("O", "").length();
        		}
			}
        	System.out.println(result);
        }
    }
}
