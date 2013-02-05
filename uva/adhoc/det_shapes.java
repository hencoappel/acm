import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
	Comp comparator;

	public Main() {
		comparator = new Comp();
	}

	double length(int[] xy1, int[] xy2) {
		return Math.sqrt(Math.pow(xy2[0] - xy1[0], 2)
				+ Math.pow(xy2[1] - xy1[1], 2));
	}

	double gradient(int[] xy1, int[] xy2) {
		return (double) (xy2[1] - xy1[1]) / (double) (xy2[0] - xy1[0]);
	}

	/**
	 * 
	 * @param p2
	 * @param p1
	 *            pivot
	 * @param p3
	 * @return
	 */
	int crossProduct(int[] p2, int[] p1, int[] p3) {
		return (p3[0] - p1[0]) * (p2[1] - p1[1]) - (p3[1] - p1[1])
				* (p2[0] - p1[0]);
	}

	int[] p;

	class Comp implements Comparator<int[]> {
		public int compare(int[] i, int[] j) {
			return crossProduct(i, p, j);
		}
	}

	void sort(int[][] xy) {
		// find point with lowest y val
		int lowest_index = 0;
		for (int i = 1; i < 4; ++i) {
			if (xy[i][1] < xy[lowest_index][1]) {
				lowest_index = i;
			} else if (xy[i][1] == xy[lowest_index][1]
					&& xy[i][0] > xy[lowest_index][0]) {
				lowest_index = i;
			}
		}
		p = xy[lowest_index];
		int[] temp = xy[0];
		xy[0] = xy[lowest_index];
		xy[lowest_index] = temp;
		long time = System.nanoTime();
		Arrays.sort(xy, comparator);
		System.out.println((double) (System.nanoTime() - time) / 1000000);
	}

	public static void main(String[] args) {
		Main m = new Main();
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("shapes.in"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		String line = null;
		int n;
		try {
			line = in.readLine();
		} catch (IOException e1) {
		}
		n = Integer.parseInt(line);
		for (int i = 0; i < n; ++i) {
			int[][] xy = new int[4][2];
			for (int j = 0; j < 4; ++j) {
				try {
					line = in.readLine();
				} catch (IOException e) {
				}
				String[] strs = line.split(" ");
				xy[j][0] = Integer.parseInt(strs[0]);
				xy[j][1] = Integer.parseInt(strs[1]);
			}
			m.sort(xy);
			double grad1 = m.gradient(xy[0], xy[1]);
			double grad2 = m.gradient(xy[1], xy[2]);
			if (grad1 == -1 / grad2) { // sqr or rect
				double length1 = m.length(xy[0], xy[1]);
				double length2 = m.length(xy[1], xy[2]);
				if (length1 == length2) {
					System.out.println("Case " + (i + 1) + ": Square");
				} else {
					System.out.println("Case " + (i + 1) + ": Rectangle");
				}
			} else {
				double length1 = m.length(xy[0], xy[1]);
				double length2 = m.length(xy[1], xy[2]);
				double length3 = m.length(xy[2], xy[3]);
				double length4 = m.length(xy[3], xy[0]);
				if (length1 == length2 && length2 == length3
						&& length3 == length4) { // Rohmbus
					System.out.println("Case " + (i + 1) + ": Rhombus");
				} else if (length1 == length3 && length2 == length4) { // parallelogram
					System.out.println("Case " + (i + 1) + ": Parallelogram");
				} else if (grad1 == m.gradient(xy[2], xy[3])
						|| grad2 == m.gradient(xy[3], xy[0])) { // trapezium
					System.out.println("Case " + (i + 1) + ": Trapezium");
				} else {
					System.out.println("Case " + (i + 1)
							+ ": Ordinary Quadrilateral");
				}
			}
		}
	}
}
