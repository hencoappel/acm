package one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Two {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("two.txt"));

		int T = Integer.parseInt(in.readLine());
		int m;
		String k1, k2;
		String[] k1sections, k2sections;
		for (int i = 1; i <= T; i++) {
			m = Integer.parseInt(in.readLine());
			k1sections = new String[m];
			k2sections = new String[m];
			k1 = in.readLine();
			k2 = in.readLine();
			int l = k1.length() / m;
			for (int j = 0; j < m; j++) {
				k1sections[j] = k1.substring(j * l, j * l + l);
				k2sections[j] = k2.substring(j * l, j * l + l);
			}
			System.out.println(Arrays.toString(k1sections));
			System.out.println(Arrays.toString(k2sections));
			boolean allHaveMatch = true;
			for (String str : k1sections) {

			}

			System.out.println("Case #" + i + ": ");
		}
	}

	static boolean match(final String str1, final String str2) {
		for (int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (!(c1 == '?' || c2 == '?' || c1 == c2)) {
				return false;
			}
		}
		return true;
	}

}
