package wk2;

public class KbasedNumbers {
	/*
	 * http://acm.timus.ru/problem.aspx?space=1&num=1009
	 */

	int calc(int k, int n) {
		return (k - 1) * calc(k - 1, n);
	}

	int calcRec(int k, int n) {
		if (n == 1) {
			return k;
		}
		
	}
}
