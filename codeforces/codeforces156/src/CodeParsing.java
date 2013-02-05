import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeParsing {
	public static void main(final String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		char[] chars = s.toCharArray();
		int x = 0, y = 0;
		for (char c : chars) {
			if (c == 'x') {
				x++;
			} else {
				y++;
			}
		}
		char toPrint = x > y ? 'x' : 'y';
		for (int i = Math.abs(x - y); i > 0; i--) {
			System.out.print(toPrint);
		}
		System.out.println();
	}
}
