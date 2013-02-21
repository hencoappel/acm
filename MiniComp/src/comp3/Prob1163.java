package comp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * http://poj.org/
 */
class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine().trim());
		int[][] tri = new int[num + 1][num + 1];

		tri[0][0] = Integer.parseInt(in.readLine().trim());
		for (int i = 1; i < num; i++) {
			String[] str = in.readLine().trim().split(" ");
			tri[i][0] = Integer.parseInt(str[0]) + tri[i - 1][0];
			for (int j = 1; j <= i; j++) {
				int temp = Integer.parseInt(str[j]);
				tri[i][j] = Math.max(tri[i - 1][j], tri[i - 1][j - 1]) + temp;
			}
		}
		int max = tri[num - 1][0];
		for (int i = 1; i < num; i++) {
			max = Math.max(max, tri[num - 1][i]);
		}
		System.out.println(max);
	}
}
