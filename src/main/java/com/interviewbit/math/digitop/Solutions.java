package com.interviewbit.math.digitop;

public class Solutions {
	public int isPalindrome(final int A) {
		if ((A >= 0) && (A < 10)) {
			return 1;
		}
		String str = "";
		int n = Math.abs(A);
		while (n != 0) {
			str += n % 10;
			n = n / 10;
		}
		if (String.valueOf(A).equals(str)) {
			return 1;
		}
		return 0;
	}

	public int check(int num) {
		int reverted = 0;
		while (num > 0) {
			reverted = (reverted * 10) + (num % 10);
			num /= 10;
		}
		return reverted;
	}

	public int reverse(final int A) {
		long n = 0;
		int abs = Math.abs(A);
		while (abs > 0) {
			n = (n * 10) + (abs % 10);
			abs = abs / 10;
		}
		if (n > Integer.MAX_VALUE) {
			return 0;
		}
		if (A < 0) {
			return (int) (n *= -1);
		}
		return (int) n;
	}

	public static void main(final String[] args) {
		System.out.println(new Solutions().reverse(-1146467285));
	}

}
