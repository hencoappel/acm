package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Three {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader in = new BufferedReader(new FileReader(
		// "beautiful_stringstxt.txt"));

		int num = Integer.parseInt(in.readLine());

		String str;
		for (int i = 1; i <= num; i++) {
			str = in.readLine();
		}
	}
}
