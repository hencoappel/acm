package comp5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
/**
 * http://acm.timus.ru/
 * 
 * 1837
 */
public class Prob1837 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());

		Map<String, Integer> memID = new TreeMap<String, Integer>();
		Map<Integer, String> reverse = new TreeMap<Integer, String>();

		int id = 0;
		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = in.readLine().trim();
			String[] line = lines[i].split(" ");
			for (int j = 0; j < line.length; j++) {
				memID.put(line[j], id);
				reverse.put(id, line[j]);
				id++;
			}
		}

		int[][] graph = new int[memID.size()][memID.size()];

		for (int i = 0; i < n; i++) {
			String[] line = lines[i].split(" ");

			int[] ids = new int[3];
			for (int j = 0; j < 3; j++) {
				ids[j] = memID.get(line[j]);
			}
			graph[ids[0]][ids[1]] = 1;
			graph[ids[1]][ids[0]] = 1;
			graph[ids[0]][ids[2]] = 1;
			graph[ids[2]][ids[0]] = 1;
			graph[ids[1]][ids[2]] = 1;
			graph[ids[2]][ids[1]] = 1;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(memID.get("Isenbaev"));
		Set<Integer> visited = new HashSet<Integer>();

		id = 0;
		while (!q.isEmpty()) {
			int j = q.poll();
			if (!visited.contains(j)) {
				visited.add(j);
				for (int i = 0; i < graph.length; i++) {
					if (graph[j][i] == 1) {
						memID.put(reverse.get(i), id);
						if (!visited.contains(i)) {
							q.add(i);
						}
					}
				}
				id++;
			}
		}
		for (Iterator<Entry<String, Integer>> it = memID.entrySet().iterator(); it
				.hasNext();) {
			Entry<String, Integer> entry = it.next();
			System.out.println(entry.toString());
		}

	}
}
