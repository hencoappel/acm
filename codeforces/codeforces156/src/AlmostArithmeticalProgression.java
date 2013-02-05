import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlmostArithmeticalProgression {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// read in n
		final int n = Integer.parseInt(in.readLine());
		// store the pairs read in
		// read nums as array of strings
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] nums = new int[n];
		// loop over 2n numbers
		for (int i = 0; i < n; i++) {
			// create a pair with the number and it's index
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			int n1 = nums[i - 1];
			int n2 = nums[i];
			int j = i + 1;
			int tempMax = 2;
			while (j < nums.length) {
				if (nums[j] == ((j - i) % 2 == 0 ? n2 : n1)) {
					tempMax++;
					j++;
				} else {
					break;
				}
			}
			max = Math.max(max, tempMax);
		}
		System.out.println(max);

	}
}
