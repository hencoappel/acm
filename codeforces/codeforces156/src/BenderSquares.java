import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BenderSquares {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// store the pairs read in
		// read nums as array of strings
		StringTokenizer st = new StringTokenizer(in.readLine());
		List<Integer> nums = new ArrayList<Integer>();
		// loop over 2n numbers
		while (st.hasMoreTokens()) {
			// create a pair with the number and it's index
			nums.add(Integer.parseInt(st.nextToken()));
		}

	}
}
