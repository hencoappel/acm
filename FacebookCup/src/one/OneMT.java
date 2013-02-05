package one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class OneMT implements TestCase {
	public static final BigInteger prime = new BigInteger("1000000007");

	public static void main(final String[] args) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("card_game.txt"));
		// BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		new MultiThreadedHarness(new OneMT(), 2, in, out).execute();
		System.out.println((System.currentTimeMillis() - time) / 1000);
	}

	static BigInteger binomial(final int n, final int k) {
		BigInteger ret = BigInteger.ONE;
		for (int i = 0; i < k; i++) {
			ret = ret.multiply(BigInteger.valueOf(n - i)).divide(
					BigInteger.valueOf(i + 1));
		}
		return ret;
	}

	@Override
	public String solveTestCase(final int id, final String[] args) {
		String[] nk = args[0].split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int nk1 = n - k + 1;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(nk1);
		{
			StringTokenizer st = new StringTokenizer(args[1]);
			while (st.hasMoreTokens()) {
				priorityQueue.add(Integer.parseInt(st.nextToken()));
				if (priorityQueue.size() > nk1) {
					priorityQueue.remove();
				}
			}
		}
		ArrayList<Integer> l = new ArrayList<Integer>(priorityQueue);
		Collections.sort(l);
		Collections.reverse(l);
		Iterator<Integer> it = l.iterator();
		n--;
		k--;
		BigInteger total = BigInteger.ZERO;
		while (n >= k) {
			int num1 = it.next();
			total = total.add(new BigInteger("" + num1)
					.multiply(binomial(n, k)));
			n--;
		}
		total = total.mod(prime);
		return "Case #" + id + ": " + total.toString();
	}
}
