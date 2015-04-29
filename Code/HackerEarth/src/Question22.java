import java.util.HashSet;
import java.util.Set;

public class Question22 {

	public static void palindromes(char[] input, int limit, int position,
			char[] tempStr, Set<String> result) {
		for (char c : input) {
			char[] str_copy = tempStr.clone();
			str_copy[position] = c;
			str_copy[(limit - 1) - position] = c;
			if (position == limit / 2) {
				// finished
				result.add(new String(str_copy));
			} else {
				palindromes(input, limit, position + 1, str_copy, result);
			}
		}
	}

	public static void main(String[] args) {
		int limit = 4;
		char[] str = new char[limit];
		char[] input = new char[] {'q','w','e','r', 't','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
		Set<String> result = new HashSet<String>();
		palindromes(input, limit, 0, str, result);
		System.out.println("Total: " + result.size());
		/*List<String> result_sorted = new ArrayList<String>(result);
		Collections.sort(result_sorted);
		for (String x : result_sorted) {
			System.out.println(x);
		}*/
	}

}
