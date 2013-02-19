package comp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = in.readLine()) != null) {
			if (line.trim().equals("")) {
				return;
			}
			int n = Integer.parseInt(line.trim().split(" ")[0]);
			if (n % 2 == 0) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
	}
}
