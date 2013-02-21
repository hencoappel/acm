package comp1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * http://poj.org/
 */
class Main {
	static class MyDouble {

		BigInteger asInt;
		Integer power;

		public MyDouble(String str) {
			int decPoint = str.indexOf(".");
			if (decPoint != -1) {
				power = 5 - decPoint;
			}
			str = str.replaceAll("\\.", "");
			asInt = new BigInteger(str);
		}
	}

	public static void main(String[] args) {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("prob1001.in"));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		String line = null;
		int n;
		int m;
		try {
			while ((line = in.readLine()) != null) {
				String[] strs = line.split(" ");
				MyDouble base = new MyDouble(strs[0]);
				int power = Integer.parseInt(strs[1]);

				BigInteger newVal = Power(base.asInt,
						new BigInteger("" + power));
				if (base.power != null) {
					BigInteger divPower = Power(new BigInteger("" + 10),
							new BigInteger("" + base.power));
					newVal = newVal.divide(divPower);
				}

				System.out.println(newVal.toString());
			}
		} catch (IOException e) {
		}
	}

	private static BigInteger Square(BigInteger number) {
		// System.err.println("Square:" + number.toString());
		return number.multiply(number);
	}

	private static BigInteger Power(BigInteger a, BigInteger exponent) {
		// System.err.println("Power");
		if (exponent.equals(BigInteger.ONE))
			return a;
		else if (exponent.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else if (exponent.getLowestSetBit() != 0)
			return Square(Power(a, exponent.divide(BigInteger.valueOf(2l))));
		else
			return a.multiply(Power(a, exponent.subtract(BigInteger.ONE)));
	}
}
