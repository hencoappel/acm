package wk1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// http://acm.sgu.ru/problem.php?contest=0&problem=101

/*
 * I've not had this accepted, though I would have though it should work.
 * My main logic consisted of the fact that you need to have an even number of all numbers,
 * so I keep track of the number of occurrences. There can be two numbers which have odd occurrences,
 * as they will go on the ends and don't have to match up. Start with a domino that has a number which has
 * an odd number of occurrences, if there is one, otherwise choose any to start, then simply find any
 * dominoes which can follow this domino and repeat. If there are two numbers with odd occurrences, the second
 * should be the last domino.
 */

public class Domino {

	static Map<Integer, int[]> dominoes;

	public static void main(String[] args) throws IOException {
		dominoes = new HashMap<Integer, int[]>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] numbers = new int[7];
		for (int i = 0; i < n; i++) {
			String[] line = in.readLine().split(" ");
			int[] domino = { Integer.parseInt(line[0]),
					Integer.parseInt(line[1]) };
			dominoes.put(i, domino);
			numbers[domino[0]]++;
			numbers[domino[1]]++;
		}
		if (n > 1) {
			for (int i = 0; i < dominoes.size(); i++) {
				if (numbers[dominoes.get(i)[0]] == 1
						&& numbers[dominoes.get(i)[1]] == 1) {
					System.out.println("No solution");
					return; // a domino that can't be connected to any others
				}
			}
		}
		Map<Integer, int[]> odds = new HashMap<Integer, int[]>();
		for (int i = 1; i <= 6; i++) {
			if (numbers[i] % 2 == 1) {
				int j = findDominoWith(i);
				odds.put(j, dominoes.remove(j));
			}
		}

		if (odds.size() > 2) {
			System.out.println("No solution");
			return;
		}

		List<String> strings = new ArrayList<String>();

		int num;
		Entry<Integer, int[]> entry;
		if (odds.size() > 0) {
			entry = odds.entrySet().iterator().next();
			odds.remove(entry.getKey());
			if (numbers[entry.getValue()[0]] % 2 == 1) {
				strings.add(entry.getKey() + 1 + " +");
				num = entry.getValue()[1];
			} else {
				strings.add(entry.getKey() + 1 + " -");
				num = entry.getValue()[0];
			}
		} else {
			entry = dominoes.entrySet().iterator().next();
			dominoes.remove(entry.getKey());
			strings.add(entry.getKey() + 1 + " +");
			num = entry.getValue()[1];
		}
		while (!dominoes.isEmpty()) {
			int index = findDominoWith(num);
			int[] domino = dominoes.remove(index);
			if (domino == null) {
				System.out.println("No solution");
				return;
			}
			if (domino[0] == num) {
				strings.add(index + 1 + " +");
				num = domino[1];
			} else {
				strings.add(index + 1 + " -");
				num = domino[0];
			}
		}
		if (!odds.isEmpty()) {
			entry = odds.entrySet().iterator().next();
			int[] domino = entry.getValue();
			odds.remove(entry.getKey());
			if (domino[0] == num) {
				strings.add(entry.getKey() + 1 + " +");
			} else {
				strings.add(entry.getKey() + 1 + " -");
			}
		}

		if (!odds.isEmpty()) {
			System.out.println("No solution");
			return;
		}

		for (String string : strings) {
			System.out.println(string);
		}

	}

	/**
	 * @return index of first domino with number in it
	 */
	public static int findDominoWith(int number) {
		for (Iterator<Entry<Integer, int[]>> it = dominoes.entrySet()
				.iterator(); it.hasNext();) {
			Entry<Integer, int[]> entry = it.next();
			if (entry.getValue()[0] == number || entry.getValue()[1] == number) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
