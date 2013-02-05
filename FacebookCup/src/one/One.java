package one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class One {
	public static final BigInteger prime = new BigInteger("1000000007");

	public static void main(final String[] args) throws IOException {
		long time = System.currentTimeMillis();
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader("card_game.txt"));

		int num = Integer.parseInt(in.readLine());

		String[] nk;
		for (int i = 1; i <= num; i++) {
			nk = in.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			int nk1 = n - k + 1;
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(
					nk1);
			{
				StringTokenizer st = new StringTokenizer(in.readLine());
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
				total = total.add(new BigInteger("" + num1).multiply(binomial(
						n, k)));
				n--;
			}
			total = total.mod(prime);
			System.out.println("Case #" + i + ": " + total.toString());

		}
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
}
