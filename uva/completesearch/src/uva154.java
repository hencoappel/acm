import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class uva154 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while (!(line = in.readLine()).equals("#")) {
				List<City> list = new ArrayList<City>();
				while (!line.startsWith("e")) {
					list.add(new City(line));
					line = in.readLine();
				}
				int best = Integer.MAX_VALUE;
				int bestI = 0;
				for (int i = 0; i < list.size(); i++) {
					City c1 = list.get(i);
					int numChanges = 0;
					for (int j = 0; j < list.size(); j++) {
						City c2 = list.get(j);
						numChanges += c1.numChangesIfChosen(c2);
					}
					int tempBest = Math.min(numChanges, best);
					if (tempBest != best) {
						best = tempBest;
						bestI = i;
					}

				}
				System.out.println(bestI + 1);
			}
		} catch (IOException e1) {
		}

		// test case
		// City c1 = new City("r/P,o/G,y/S,g/A,b/N");
		// City c2 = new City("o/G,r/P,g/A,b/N,y/S");
		// System.out.println("c1 c1: expect 0 changes, get " +
		// c1.numChangesIfChosen(c1)
		// + " changes");
		// System.out.println("c1 c2: expect 0 changes, get " +
		// c1.numChangesIfChosen(c2)
		// + " changes");
		// City c3 = new City("r/G,o/S,y/A,g/N,b/P");
		// System.out.println("c1 c3: expect 5 changes, get " +
		// c1.numChangesIfChosen(c3)
		// + " changes");
		// System.out.println("c3 c1: expect 5 changes, get " +
		// c3.numChangesIfChosen(c1)
		// + " changes");
		// City c4 = new City("r/G,o/P,y/S,g/A,b/N");
		// System.out.println("c1 c4: expect 2 changes, get " +
		// c1.numChangesIfChosen(c4)
		// + " changes");

	}

	static class City {
		Set<String> set = new HashSet<String>();

		public City(String str) {
			String[] strs = str.split(",");
			for (String string : strs) {
				set.add(string);
			}
		}

		int numChangesIfChosen(City c) {
			Set<String> intersection = new HashSet<String>(c.set);
			intersection.retainAll(set);
			return set.size() - intersection.size();
		}

	}

}
