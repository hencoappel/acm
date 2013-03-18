package wk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// http://acm.sgu.ru/problem.php?contest=0&problem=230
public class Weighings {

	static int MAX = 101;

	static int[][] graph = new int[MAX][MAX];
	static int[] deg = new int[MAX];

	public static void main(String[] args) throws IOException {
		int n, m;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		int j, k;
		Set<Integer> seen = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			line = in.readLine().split(" ");
			j = Integer.parseInt(line[0]);
			k = Integer.parseInt(line[1]);
			graph[j][k] = 1;
			// Circular reference
			if (graph[k][j] == 1) {
				System.out.println("No solution");
				return;
			}
			deg[k]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> finals = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (deg[i] == 0) {
				q.offer(i);
			}
		}

		if (q.isEmpty()) {
			System.out.println("No solution");
			return;
		}

		Queue<Integer> bfs = new LinkedList<Integer>();
		bfs.offer(q.peek());

		while (!bfs.isEmpty()) {
			j = bfs.poll();
			for (int i = 1; i <= n; i++) {
				if (seen.contains(i) && (graph[j][i] == 1 || graph[i][j] == 1)) {
					bfs.offer(i);
				}
			}
			seen.add(j);
		}

		// Some have not been weighed
		if (seen.size() != n) {
			System.out.println("No solution");
			return;
		}

		while (!q.isEmpty()) {
			int temp = q.poll();
			finals.offer(temp);
			for (int i = 1; i <= n; i++) {
				if (graph[temp][i] == 1 && --deg[i] == 0) {
					q.offer(i);
				}
			}
		}

		if (finals.size() != n) {
			System.out.println("No solution");
			return;
		}

		while (finals.size() > 1) {
			System.out.print(finals.poll() + " ");
		}
		System.out.println(finals.poll());
	}

}