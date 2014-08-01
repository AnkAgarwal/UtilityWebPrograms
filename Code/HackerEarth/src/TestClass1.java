import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


class TestClass1 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
 */
    	BufferedReader br = new BufferedReader(new FileReader(new File("Data1")));
        String line = br.readLine();
        ArrayList<Character> vowels=new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	
            String text=br.readLine().trim();
            int decreasedLen=text.length()-4;
            for (int j = 4; j < text.length()-4; j++) {
				if(vowels.contains(text.charAt(j))){
					decreasedLen--;
				}
			}
            System.out.println(decreasedLen+"/"+text.length());
            
        }
       

        //System.out.println("Hello World!");
    }
}