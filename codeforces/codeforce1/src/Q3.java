import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {

	public static void main(String[] args) {

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("q3.in"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		String line = null;
		int n;
		try {
			line = in.readLine();
			String[] strs = line.split(" ");
			n = Integer.parseInt(strs[0]);
			int maxLength = Integer.parseInt(strs[1]);
			if (n <= 2) { // can't unsort
				System.out.println(-1);
				return;
			}
			line = in.readLine();
			strs = line.split(" ");
			int[] array = new int[n];
			// parse ints
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(strs[i]);
			}

			int c = 0;
			
			for (int i = 0; i < array.length - 2; i++) {
				int limit = array.length - i;
				int j = 0;
				while (j < limit && array[j] - array[i] <= maxLength)
					j++;
//				if (i == j)
//					break;
				int N = j - i;
				double fact = factorial(N - 3);
				double fact2 = fact * N * (N - 1);
				double num = fact2 / (6 * fact);
				c += num;
				i = j;
			}

			System.out.println(c);
			System.out.println(factorial(10000));
		} catch (IOException e) {
		}
	}

	static double factorial(double i) {
		double temp = 1;
		for (; i > 1; i--) {
			temp *= i;
		}
		return temp;
	}
}
