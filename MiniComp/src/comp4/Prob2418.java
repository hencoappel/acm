package comp4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Main3 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String line = null;
		double i = 0;
		while ((line = in.readLine()) != null) {
			if (map.containsKey(line)) {
				map.put(line, map.get(line) + 1);
			} else {
				map.put(line, 1);
			}
			i += 1;
		}
		for (Iterator<Entry<String, Integer>> it = map.entrySet().iterator(); it
				.hasNext();) {
			Entry<String, Integer> entry = it.next();
			System.out.printf("%s %.4f\n", entry.getKey(), ((double) entry
					.getValue().doubleValue() * 100) / i);
		}
	}

	static String to4dp(double i) {
		i = Math.round(i * 10000);
		i /= 10000d;
		return "" + i;
	}
}
