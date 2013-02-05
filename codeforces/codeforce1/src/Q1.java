import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {

	public static void main(String[] args) {
		 BufferedReader in = new BufferedReader(new
		 InputStreamReader(System.in));
		String line = null;
		int n;
		try {
			line = in.readLine();
			n = Integer.parseInt(line);
			line = in.readLine();
			String[] strs = line.split(" ");
			int[] array = new int[n];
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(strs[i]);
			}

			int max = array[0];

			for (int i = 0; i < array.length; ++i) {
				int last = array[i];
				max = Math.max(max, last);
				for (int j = i + 1; j < array.length; ++j) {
					int temp = last ^ array[j];
					last = temp;
					max = Math.max(max, last);
				}
			}
			System.out.println(max);
		} catch (IOException e) {
		}
	}
}
