package comp4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * http://poj.org/
 */
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int j = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < j; i++) {
			String line = in.readLine().trim();
			double num = (double) Integer.parseInt(line);
			int s = 0;
			Double newNum = num / 5;
			while (newNum - newNum.intValue() != 0) {
				num--;
				newNum = num / 5;
			}
			for (; num > 0; num -= 5) {
				newNum = num;
				newNum = newNum / 5;
				while (newNum - newNum.intValue() == 0) {
					s++;
					newNum = newNum / 5;
				}
			}
			System.out.println(s);
		}
	}
}
