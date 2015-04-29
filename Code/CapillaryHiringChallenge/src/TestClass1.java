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
        String[] param = br.readLine().split("\\s");
        int numBox=Integer.parseInt(param[0]);
        int numQueries=Integer.parseInt(param[1]);
        ArrayList<RodDet> connected=new ArrayList<RodDet>();
        int median=numBox/2;
        for (int k = 0; k < numQueries; k++) {
        	String[] ij=br.readLine().split("\\s");
        	if(ij[0].equals(ij[1]))
        		System.out.println("NO");
        	
        	int i=Integer.parseInt(ij[0]);
        	int j=Integer.parseInt(ij[1]);
        	RodDet obj=new RodDet(i, j);
        	if(i==j){
        		System.out.println("NO");
        	}else if(connected.contains(obj) || connected.contains(obj)){        	
        		System.out.println("NO");
        	}/*else if(check(connected,obj) ==false){
        		System.out.println("NO");
        	}*/else{
        		connected.add(obj);
        		System.out.println("YES");
        	}
        }
        	
            
    }

	/*private static boolean check(ArrayList<RodDet> connected, RodDet obj) {
		for (int i = 0; i < connected.size(); i++) {
			RodDet listItem=connected.get(i);
			if (){
				return false;
			}
		}
		return false;
	}*/
       

    }


class RodDet{
	int x;
	int y;
	
	public RodDet(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		boolean retVal=false;
		if(arg0 instanceof RodDet){
			RodDet obj=(RodDet) arg0;
			if(this.x==obj.x || this.y==obj.y)
				retVal=true;
		}
		return retVal;
			
	}
}