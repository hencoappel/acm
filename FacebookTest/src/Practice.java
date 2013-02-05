import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Practice {
	@SuppressWarnings("unchecked")
	public static void main(final String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			int n, k;
			n = Integer.parseInt(in.readLine());
			k = Integer.parseInt(in.readLine());// pegs
			int[] initialConfig = new int[n];
			int[] finalConfig = new int[n];
			String[] strs1 = in.readLine().split(" ");
			String[] strs2 = in.readLine().split(" ");
			Stack<Integer>[] peg = new Stack[k];
			for (int i = 0; i < peg.length; i++) {
				peg[i] = new Stack<Integer>();
			}
			for (int i = n; i > 0; i--) {
				initialConfig[i] = Integer.parseInt(strs1[i]);
				peg[initialConfig[i]].push(i);
				finalConfig[i] = Integer.parseInt(strs2[i]);
			}
			Queue<String> moves = new LinkedList<String>();
			Arrays.equals(initialConfig, finalConfig);

		} catch (IOException e1) {
		}
	}
}
