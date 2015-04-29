package porter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"Porter2")));
		String line = br.readLine();
		String[] arrInput = line.split("\\s");
		//int numStudents = Integer.parseInt(arrInput[0]);
		int numFriendShip = Integer.parseInt(arrInput[1]);

		String[] studentSex = br.readLine().split("\\s");
		Map<String, SexCount> friendsCountMap = new LinkedHashMap<String, SexCount>();
		for (int i = 0; i < numFriendShip; i++) {
			String[] frndShip = br.readLine().split("\\s");
			if (friendsCountMap.get(frndShip[0]) == null) {
				SexCount obj = new SexCount();
				if (studentSex[Integer.parseInt(frndShip[1]) - 1].equals("B"))
					obj.boys = obj.boys + 1;
				else
					obj.girls = 1;
				
				friendsCountMap.put(frndShip[0], obj);
			}else{
				SexCount obj = friendsCountMap.get(frndShip[0]);
				if (studentSex[Integer.parseInt(frndShip[1]) - 1].equals("B"))
					obj.boys = obj.boys + 1;
				else
					obj.girls = 1;
			}
		}
		System.out.println(friendsCountMap);
		int result = 0;
		Iterator iterator = friendsCountMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			String key = (String) mapEntry.getKey();
			SexCount obj = (SexCount) mapEntry.getValue();
			String selectedStudentSex = studentSex[Integer.parseInt(key) - 1];
			if(selectedStudentSex.equals("B") && obj.boys > obj.girls)
				result = result+ 1 + obj.girls;
			else if(selectedStudentSex.equals("B") && obj.boys < obj.girls)
				result = result+ obj.boys;
			else if(selectedStudentSex.equals("G") && obj.boys > obj.girls)
				result = result + obj.girls;
			else if(selectedStudentSex.equals("G") && obj.boys <= obj.girls)
				result = result+1+ obj.boys;
			else
				result = result + obj.boys;
		}
		System.out.println(result);
	}

}

class SexCount {
	int boys = 0;
	int girls = 0;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return boys+ " : "+ girls;
	}
}
