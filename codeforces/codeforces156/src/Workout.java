import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Workout {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// read in n
		final int n = Integer.parseInt(in.readLine());
		// store the pairs read in
		// read nums as array of strings
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] repeats = new int[n];
		// loop over 2n numbers
		for (int i = 0; i < n; i++) {
			// create a pair with the number and it's index
			repeats[i] = Integer.parseInt(st.nextToken());
		}
		int chest = 0, biceps = 0, back = 0;
		for (int i = 0; i < n; i++) {
			switch (i % 3) {
			case 0:
				chest += repeats[i];
				break;
			case 1:
				biceps += repeats[i];
				break;
			case 2:
				back += repeats[i];
				break;
			}
		}
		if (chest > biceps && chest > back) {
			System.out.println("chest");
		} else if (biceps > chest && biceps > back) {
			System.out.println("biceps");
		} else {
			System.out.println("back");
		}

	}
}
