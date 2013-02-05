import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class uva441 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader in = null;
		// try {
		// in = new BufferedReader(new FileReader("uva441.in"));
		// } catch (FileNotFoundException e2) {
		// e2.printStackTrace();
		// }
		String line = null;
		try {
			if ((line = in.readLine()).equals("0")) {
				return;
			}
			while (true) {
				new MySet(line).printOut();
				if ((line = in.readLine()).equals("0")) {
					break;
				}
				System.out.println("");
			}

		} catch (IOException e1) {
		}

	}

	static class MySet {
		int size; // nums.length
		int[] nums;

		public MySet(String str) {
			String[] strs = str.split(" ");
			size = Integer.parseInt(strs[0]);
			nums = new int[size];
			for (int i = 0; i < size; i++) {
				nums[i] = Integer.parseInt(strs[i + 1]);

			}
		}

		void printOut() {
			for (int i = 0; i < size - 5; i++) {
				for (int j = i + 1; j < size - 4; j++) {
					for (int k = j + 1; k < size - 3; k++) {
						for (int l = k + 1; l < size - 2; l++) {
							for (int m = l + 1; m < size - 1; m++) {
								for (int n = m + 1; n < size; n++) {
									System.out.println(nums[i] + " " + nums[j]
											+ " " + nums[k] + " " + nums[l]
											+ " " + nums[m] + " " + nums[n]);
								}
							}
						}
					}
				}
			}

		}

	}

}
