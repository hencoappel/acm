package qualifying;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BeautifulSentence {
	public static void main(final String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader(
				"beautiful_stringstxt.txt"));
		int num = Integer.parseInt(in.readLine());
		char[] str;
		int[] alphabet;
		for (int i = 1; i <= num; i++) {
			alphabet = new int[26];
			str = in.readLine().toLowerCase().toCharArray();
			for (char c : str) {
				if (c >= 'a' && c <= 'z') {
					alphabet[c - 'a']++;
				}
			}
			Arrays.sort(alphabet);
			int j = 25;
			int total = 0;
			while (j >= 0 && alphabet[j] > 0) {
				total += (j + 1) * alphabet[j];
				j--;
			}
			System.out.println("Case #" + i + ": " + total);
		}
	}
}
