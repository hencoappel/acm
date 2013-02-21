package acm.sgu.ru;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Contest0Prob230 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().trim().split(" ");
		int n, m;
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		int[][] graph = new int[n + 1][n + 1];
		int[] deg = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			line = in.readLine().trim().split(" ");
			int p, q;
			p = Integer.parseInt(line[0]);
			q = Integer.parseInt(line[1]);

			graph[p][q] = 1;
			deg[q]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			if (deg[i] == 0) {
				q.add(i);
			}
		}
		int node = 0;
		String str = "";
		while (!q.isEmpty()) {
			node = q.poll();
			if (!visited.contains(node)) {
				str += node + " ";
				visited.add(node);
				for (int i = 1; i <= n; i++) {
					if (graph[node][i] == 1) {
						deg[i]--;
						if (deg[i] == 0) {
							q.add(i);
						}
					}
				}
			}
		}
		if (visited.size() != n) {
			System.out.println("No solution");
		} else {
			System.out.println(str.trim());
		}
	}
}
