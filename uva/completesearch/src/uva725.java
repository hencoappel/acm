import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class uva725 {
	/** >=10000 */
	public static final Set<Integer> set1 = new HashSet<Integer>();
	/** <10000 */
	public static final Set<Integer> set2 = new HashSet<Integer>();
	static {
		for (int i = 1000; i < 100000; i++) {
			if (allDiffNums(i)) {
				if (i >= 10000) {
					set1.add(i);
				} else {
					set2.add(i);
				}
			}
		}
	}

	static boolean allDiffNums(int num) {
		return allDiffNums(Integer.toString(num));
	}

	static boolean allDiffNums(String s) {
		char[] str = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : str) {
			set.add(c);
		}
		return str.length == set.size();
	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		 BufferedReader in = null;
//		 try {
//		 in = new BufferedReader(new FileReader("uva725.in"));
//		 } catch (FileNotFoundException e2) {
//		 e2.printStackTrace();
//		 }
		String line = null;
		try {
			if ((line = in.readLine()).equals("0")) {
				return;
			}
			while (true) {
				new MySet(line).printOut();
				if ((line = in.readLine()).equals("0")) {
					break;
				}
				System.out.println("");
			}

		} catch (IOException e1) {
		}

	}

	static class MySet {
		int num; // nums.length
		Set<String> finalSet;

		public MySet(String str) {
			num = Integer.parseInt(str);
			Set<String> set = new HashSet<String>();
			// for >=10000
			for (Iterator<Integer> it = set1.iterator(); it.hasNext();) {
				Integer integer = it.next();
				if (set1.contains(num * integer)) {
					set.add(num * integer + "" + integer);
				}
			}
			// for <1000
			for (Iterator<Integer> it = set2.iterator(); it.hasNext();) {
				Integer integer = it.next();
				if (set1.contains(num * integer)) {
					set.add(num * integer + "0" +integer);
				}
			}
			finalSet = new TreeSet<String>();
			// filter out strings that would be illegal
			for (Iterator<String> it = set.iterator(); it.hasNext();) {
				String str1 = it.next();
				if (allDiffNums(str1)) {
					finalSet.add(str1);
					// System.out.println(str1);
				}
			}
		}

		void printOut() {
			if (finalSet.isEmpty()) {
				System.out.println("There are no solutions for " + num + ".");
			}
			for (Iterator<String> it = finalSet.iterator(); it.hasNext();) {
				String str = it.next();
				System.out.println(str.substring(0, 5) + " / "
						+ str.substring(5, 10) + " = " + num);
			}
		}

	}

}
