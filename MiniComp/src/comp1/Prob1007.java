package comp1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Main2 {

	public static void main2(String[] args) {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("prob1007.in"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		String line = null;
		int n;
		int m;
		try {
			while ((line = in.readLine()) != null) {
				String[] strs = line.split(" ");
				double base = Double.parseDouble(strs[0]);
				int power = Integer.parseInt(strs[0]);

				Double val = Math.pow(base, power);
				int intVal = val.intValue();

				if (intVal == 0) {// 0 val
					System.out.println(val);
				} else if (val - intVal == 0) {// int
					System.out.println(intVal);
				}

			}
		} catch (IOException e) {
		}
	}
}
