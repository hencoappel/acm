package qualifying;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalanceSmileys {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader in = new BufferedReader(new FileReader(
		// "beautiful_stringstxt.txt"));
		int num = Integer.parseInt(in.readLine());
		String str;
		for (int i = 1; i <= num; i++) {

			str = in.readLine().replaceAll(":[^\\(\\)]", "");
			str = str.replaceAll("[a-zA-Z]", "");
			str = str.replaceAll(" ", "");

			while (str.length() > 0) {
				if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
					str = str.substring(1, str.length() - 1);
				} else if (str.charAt(0) == ':') {

				}
			}
		}
	}
}
