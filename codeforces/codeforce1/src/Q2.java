import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q2 {

	public static void main(String[] args) {

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("q2.in"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		String line = null;
		int n;
		try {
			line = in.readLine();
			n = Integer.parseInt(line);
			if (n <= 2) { // can't unsort
				System.out.println(-1);
				return;
			}
			line = in.readLine();
			String[] strs = line.split(" ");
			int[] array = new int[n];
			// parse ints
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(strs[i]);
			}

		} catch (IOException e) {
		}
	}

	boolean isSorted(int[] nums) {
		return isSortedAsc(nums) || isSortedDesc(nums);
	}

	boolean isSortedAsc(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < nums[i + 1]) {
				return false;
			}
		}
		return true;
	}

	boolean isSortedDesc(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
