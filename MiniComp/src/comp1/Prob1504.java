package comp1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * http://poj.org/
 */
class Main1 {
	public static void main2(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n;
		try {
			line = in.readLine();
			n = Integer.parseInt(line);
			for (int i = 0; i < n; i++) {
				line = in.readLine();
				String[] strs = line.split(" ");
				int[] nums = new int[n];
				// parse ints
				for (int j = 0; j < 2; j++) {
					nums[j] = Integer.parseInt(revString(strs[j]));
				}

				int sum = nums[0] + nums[1];

				System.out.println(Integer.parseInt(revString("" + sum)));

			}
		} catch (IOException e) {
		}
	}

	private static String revString(String str) {
		StringBuilder sb = new StringBuilder(str.length() + 1);
		for (int i = 1; i <= str.length(); i++) {
			sb.append(str.charAt(str.length() - i));
		}
		return sb.toString();
	}
}
