package wk2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class OutOfHay {
	
	/*
	 *  http://poj.org/problem?id=2395
	 *  
	 *  ACCEPTED
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		DisjointSet ds = new DisjointSet(n + 1);
		int[][] matrix = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
			public int compare(int[] road1, int[] road2) {
				return road1[2] - road2[2];
			}
		});
		for (int i = 0; i < m; i++) {
			line = in.readLine().split(" ");
			int[] road = { Integer.parseInt(line[0]),
					Integer.parseInt(line[1]), Integer.parseInt(line[2]) };
			if (matrix[road[0]][road[1]] > road[2]) { // new road is shorter
				// store for both directions
				matrix[road[0]][road[1]] = road[2];
				matrix[road[1]][road[0]] = road[2];
				q.add(road);
			}
		}
		// make minimum spanning tree
		int maxRoad = 0;
		while (!q.isEmpty()) {
			int[] road = q.poll();
			if (ds.find(road[0]) != ds.find(road[1])) {
				ds.union(road[0], road[1]);
				maxRoad = Math.max(maxRoad, road[2]);
			}
		}
		System.out.println(maxRoad);
	}

	static class DisjointSet {
		int[] parent;

		DisjointSet(int size) {
			parent = new int[size];
			Arrays.fill(parent, -1);
		}

		void union(int node1, int node2) {
			parent[find(node1)] = find(node2);
		}

		int find(int node) {
			if (parent[node] < 0) {
				return node;
			}
			return parent[node] = find(parent[node]);
		}
	}
}
