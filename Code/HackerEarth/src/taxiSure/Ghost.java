package taxiSure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Element implements Comparable<Element> {
	int ghostAge;
	int count;
	static boolean flag=false;

	public Element(int ghostAge) {
		// TODO Auto-generated constructor stub
		this.ghostAge = ghostAge;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.ghostAge + " : " + this.count;
	}

	@Override
	public int compareTo(Element comparePriority) {
		
		if(flag)
			return -1;

		int count = (int) comparePriority.count;
		int ghostAge = (int) comparePriority.ghostAge;

		if(this.count == 0 && this.ghostAge==ghostAge){
			
			flag=true;
			return 0;
		}
			
		// for desending order
		if (count != this.count)
			return count - this.count;
		else
			return ghostAge - this.ghostAge;
	}

	public static Comparator<Element> ageComparator = new Comparator<Element>() {

		public int compare(Element element1, Element element2) {

			int count1 = element1.count;
			int count2 = element2.count;

			int ghostAge1 = element1.ghostAge;
			int ghostAge2 = element2.ghostAge;

			/*
			 * if(ghostAge1 == ghostAge2) return 0;
			 */

			// descending order
			if (count2 != count1)
				return count2 - count1;
			else {
				return ghostAge2 - ghostAge1;
			}
		}

	};

	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null)
			return false;

		if (arg0 instanceof Element) {
			Element obj = (Element) arg0;

			if (this.ghostAge == obj.ghostAge)
				return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.ghostAge + this.count;
	}
}

public class Ghost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br;
		// HashMap<String,Integer> elementList = new HashMap<String, Integer>();
		/*
		 * SortedSet<Element> elementList = new TreeSet<Element>(
		 * Element.ageComparator);
		 */
		SortedSet<Element> elementList = new TreeSet<Element>();
		try {
			br = new BufferedReader(new FileReader(new File("DataGhost")));
			String line = br.readLine();
			int N = Integer.parseInt(line.split("\\s")[0]);

			String[] input = br.readLine().split("\\s");

			for (int i = 0; i < N; i++) {
				int ghostAge = Integer.parseInt(input[i]);
				Element obj = new Element(ghostAge);
				if (elementList.contains(obj) == false) {
					// SortedSet subset = elementList.headSet(obj);
					// if (subset.isEmpty())
					obj.count = 1;
				} else {
					Element.flag=false;
					SortedSet subset = elementList.tailSet(obj);
					obj = (Element) subset.first();
					obj.count = obj.count + 1;
					// elementList.add(obj);
				}

				elementList.add(obj);

				System.out.println(elementList.first().ghostAge + " "
						+ elementList.first().count);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
