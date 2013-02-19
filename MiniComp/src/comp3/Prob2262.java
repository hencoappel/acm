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
class Sieve {
	private BitSet sieve;

	public Sieve(int size) {
		sieve = new BitSet((size + 1) / 2);
	}

	public boolean is_composite(int k) {
		assert k >= 3 && (k % 2) == 1;
		return sieve.get((k - 3) / 2);
	}

	public void set_composite(int k) {
		assert k >= 3 && (k % 2) == 1;
		sieve.set((k - 3) / 2);
	}

	public List<Integer> sieve_of_eratosthenes(int max) {
		Sieve sieve = new Sieve(max + 1); // +1 to include max itself
		for (int i = 3; i * i <= max; i += 2) {
			if (sieve.is_composite(i))
				continue;

			// We increment by 2*i to skip even multiples of i
			for (int multiple_i = i * i; multiple_i <= max; multiple_i += 2 * i)
				sieve.set_composite(multiple_i);

		}
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 3; i <= max; i += 2)
			if (!sieve.is_composite(i))
				primes.add(i);

		return primes;
	}
}
