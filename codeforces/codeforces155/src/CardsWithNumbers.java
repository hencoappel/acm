import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardsWithNumbers {
	static class Pair implements Comparable<Pair> {
		int k;// number read in
		int v;// position read in starting from 1

		public Pair(String k, int v) {
			this.k = Integer.parseInt(k);
			this.v = v + 1;
		}

		@Override
		public int compareTo(Pair otherPair) {
			return k - otherPair.k;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

		// read in n
		int n = Integer.parseInt(in.readLine());
		int n2 = n * 2;
		// store the pairs read in
		Pair[] list = new Pair[n2];
		// read nums as array of strings
		StringTokenizer st = new StringTokenizer(in.readLine());
		// loop over 2n numbers
		for (int i = 0; i < n2; i++) {
			// create a pair with the number and it's index
			list[i] = new Pair(st.nextToken(), i);
		}
		Arrays.sort(list);
		String[] newList = new String[n];
		for (int i = 0; i < list.length - 1; i += 2) {
			Pair p1 = list[i];
			Pair p2 = list[i + 1];
			if (p1.k != p2.k) {
				out.write("-1");
//				out.newLine();
				out.flush();
				out.close();
				return;
			}
			newList[i / 2] = p1.v + " " + p2.v;
		}
		for (int i = 0; i < newList.length; i++) {
			out.write(newList[i]);
			if (i < newList.length - 1)
				out.newLine();
		}
		// flush
		out.flush();
		out.close();
	}
}
