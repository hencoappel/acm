package comp5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://acm.timus.ru/
 * 
 * 1106
 */
public class Prob1106 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());

		int[][] graph = new int[n + 1][];

		for (int i = 0; i < n; i++) {
			String[] line = in.readLine().trim().split(" ");
			int[] nums = new int[line.length - 1];

			for (int j = 0; j < nums.length; j++) {
				nums[j] = Integer.parseInt(line[j]);
			}
			graph[i + 1] = nums;
		}

	}
}
