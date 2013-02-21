package comp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * http://poj.org/
 */
class Main1 {
	public static void main(String[] args) {
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n;
		int m;
		List<Integer> primes = new Sieve((int) 1e6).sieve_of_eratosthenes((int) 1e6);
		Set<Integer> primesSet = new HashSet<Integer>(primes);
		try {
			while ((line = in.readLine()) != null) {
				int num = Integer.parseInt(line);
				if (num == 0) {
					return;
				}
				int halfnum = num / 2;
				for (int p : primes) {
					if (p > halfnum) {
						break;
					}
					if (primesSet.contains(num - p)) {
						System.out.println(num + " = " + p + " + " + (num - p));
						break;
					}
				}
			}
		} catch (IOException e) {
		}
	}

	
}
