package comp5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * http://acm.timus.ru/
 * 
 * 1022
 */
public class Prob1022 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());

		int[][] graph = new int[n + 1][n + 1];
		int[] deg = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			String[] line = in.readLine().trim().split(" ");
			for (int j = 0; j < line.length - 1; j++) {
				int m = Integer.parseInt(line[j]);
				graph[i][m] = 1;
				deg[m]++;
			}
		}

		Set<Integer> visisted = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> order = new Stack<Integer>();

		for (int i = 1; i < deg.length; i++) {
			if (deg[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int num = q.poll();
			if (!visisted.contains(num)) {
				visisted.add(num);
				order.add(num);
				for (int i = 1; i < graph.length; i++) {
					if (graph[num][i] == 1) {
						deg[i]--;
						if (deg[i] == 0) {
							q.add(i);
						}
					}
				}
			}
		}
		String str = order.toString();
		str = str.substring(1, str.length() - 1);
		System.out.println(str.replaceAll(",", ""));

	}
}
