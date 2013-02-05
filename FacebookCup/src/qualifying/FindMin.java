package qualifying;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindMin {
	public static void main(final String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader(
				"find_the_mintxt.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("out3.txt"));
		int num = Integer.parseInt(in.readLine());
		int n, k, a, b, c, r;
		String[] str;
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
			List<Integer> list = new LinkedList<Integer>();
			str = in.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			k = Integer.parseInt(str[1]);

			str = in.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]);
			r = Integer.parseInt(str[3]);

			int prev = a;
			list.add(prev);
			for (int j = 1; j < k; j++) {
				prev = (b * prev + c) % r;
				list.add(prev);
			}
			List<Integer> list2 = new LinkedList<>();
			Collections.copy(list2, list);
			Collections.sort(list2);
			int num_k = 0;
			for (int l = k; l < n; l++) {
				num_k = 0;
				while (list.contains(num_k)) {
					num_k++;
				}
				list.remove(0);
				list.add(num_k);
			}
			out.write("Case #" + i + ": " + num_k);
		}
		out.close();
	}
}
