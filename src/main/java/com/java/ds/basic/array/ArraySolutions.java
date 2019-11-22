package com.java.ds.basic.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class ArraySolutions {

	public int longestCommonSumSpan(final int[] arr1, final int[] arr2, final int arrLength) {
		int maxSpan = 0;
		for (int i = 0; i < arrLength; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = i; j < arrLength; j++) {
				sum1 += arr1[j];
				sum2 += arr2[j];
				if (sum1 == sum2) {
					final int length = (j - i) + 1;
					if (length > maxSpan) {
						maxSpan = length;
					}
				}
			}
		}
		return maxSpan;
	}

	public void reverse(final Stack<Integer> s) {
		// int tmp = -1;
		if (s.isEmpty()) {
			return;
		}

		final int tmp = s.pop();
		this.reverse(s);
		this.add(s, tmp);
		// s.insertElementAt(tmp, 0);
	}

	private void add(final Stack<Integer> s, final int tmp) {
		if (s.isEmpty()) {
			s.push(tmp);
			return;
		}
		final int obj = s.pop();
		this.add(s, tmp);
		s.push(obj);
	}
	// 1) Since there are total n elements, maximum sum is n for both arrays.

	// 2) Difference between two sums varies from -n to n. So there are total 2n
	// + 1 possible values of difference.

	// 3) If differences between prefix sums of two arrays become same at two
	// points, then subarrays between these two points have same sum.

	// Using Auxiliary Array

	public int longestCommonSumSpan2(final int[] arr1, final int[] arr2, final int length) {
		int maxSpan = 0;
		int prevSum1 = 0;
		int prevSum2 = 0;
		final int diff[] = new int[(2 * length) + 1];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = -1;
		}
		for (int i = 0; i < length; i++) {
			prevSum1 += arr1[i];
			prevSum2 += arr2[i];
			final int curr_diff = prevSum1 - prevSum2;
			final int diff_index = length + curr_diff;
			if (curr_diff == 0) {
				maxSpan = i + 1;
			} else if (diff[diff_index] == -1) {
				diff[diff_index] = i;
			} else {
				final int len = i - diff[diff_index];
				if (len > maxSpan) {
					maxSpan = len;
				}
			}

		}
		return maxSpan;
	}

	// Union of two sorted arrays
	public List<Integer> union(final int[] arr1, final int[] arr2, final int arr1Length, final int arr2Length) {
		final List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while ((i < arr1Length) && (j < arr2Length)) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				result.add(arr1[i]);
				i++;
			} else {
				result.add(arr2[j]);
				j++;
			}
		}
		while (i < arr1Length) {
			result.add(arr1[i]);
			i++;
		}
		while (j < arr2Length) {
			result.add(arr2[j]);
			j++;
		}
		return result;
	}

	// Intersection of two sorted arrays
	public List<Integer> intersection(final int[] arr1, final int[] arr2, final int arr1Length, final int arr2Length) {
		final List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while ((i < arr1Length) && (j < arr2Length)) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}

	public void test() {
		final int a = 61;
		final int n = 6;
		final int d = 1;
		final int b[] = { 62, 66, 63, 64, 65 };
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			sum += b[i];
		}
		final int actual = (n / 2) * (((2 * a) + ((n - 1) * d)));
		System.out.println(actual - sum);
	}

	public int missingNo(final int[] arr1, final int n) {
		// total=n*(n+1)/2
		final int j = n + 1;
		int total = (j * (j + 1)) / 2;
		// int total = ((n + 1) * (n + 2)) / 2;
		for (int i = 0; i < n; i++) {
			total -= arr1[i];
		}
		return total;
	}

	public int minDist(final int arr[], final int x, final int y) {
		int min_dist = Integer.MAX_VALUE;
		int i = 0;
		int prev = 0;
		for (; i < arr.length; i++) {
			if ((arr[i] == x) || (arr[i] == y)) {
				prev = i;
				break;
			}
		}
		for (; i < arr.length; i++) {
			if ((arr[i] == x) || (arr[i] == y)) {
				if (arr[i] != arr[prev]) {
					if (min_dist > (i - prev)) {
						min_dist = i - prev;
					}
				}
				prev = i;
			}
		}
		return min_dist;
	}

	public int mooreMajorityAlgo(final int[] arr) {
		int m = 0, i = 0;
		System.out.println(arr);
		for (int x = 0; x < arr.length; x++) {
			System.out.print(" M " + m);
			System.out.print(" I " + i);
			System.out.print(" X " + x);
			if (i == 0) {
				m = x;
				i = 1;
			} else if (arr[m] == arr[x]) {
				i++;
			} else {
				i--;
			}
			System.out.println("");
		}
		return m;
	}

	// https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
	public int getOddOccurence(final int[] arr) {
		int res = 0;
		// System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Integer.toBinaryString(res) + " ^ " + Integer.toBinaryString(arr[i]));
			res = res ^ arr[i];
			// System.out.println(arr[i] + " : " + res);
		}
		return res;
	}

	// https://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
	public void subArray(final int[] arr, final int n) {
		// Pick starting point
		for (int i = 0; i < n; i++) {
			// Pick ending point
			for (int j = i; j < n; j++) {
				// Print subarray between current starting
				// and ending points
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + "");
				}
			}
		}
	}

	// https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
	public int fixPointByBinarySearch(final int arr[], final int low, final int high) {
		if (high > low) {
			final int mid = low + ((high - low) / 2);
			if (mid == arr[mid]) {
				return mid;
			}
			if (mid < arr[mid]) {
				return this.fixPointByBinarySearch(arr, low, mid + 1);
			} else {
				return this.fixPointByBinarySearch(arr, mid + 1, high);
			}
		}

		return -1;
	}

	// https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
	public void nextGreatest(final int[] arr, final int n) {
		int maxFromRight = arr[n - 1];
		arr[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			final int temp = arr[i];
			arr[i] = maxFromRight;
			if (temp > maxFromRight) {
				maxFromRight = temp;
			}
		}
	}

	// https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
	public int findPeek(final int[] arr, final int low, final int high, final int n) {
		final int mid = low + ((high - low) / 2);
		if (((mid == 0) || (arr[mid] >= arr[mid - 1])) && ((mid == (n - 1)) || (arr[mid] >= arr[mid + 1]))) {
			return mid;
		} else if ((mid > 0) && (arr[mid] < arr[mid - 1])) {
			return this.findPeek(arr, low, mid - 1, n);
		} else {
			return this.findPeek(arr, mid + 1, high, n);
		}
	}

	public int countIncreasing(final int[] arr, final int n) {
		// Initialize count of subarrays as 0
		int cnt = 0;

		// Pick starting point
		for (int i = 0; i < n; i++) {
			// Pick ending point
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[j - 1]) {
					cnt++;
				} else {
					break;
				}
			}
		}
		return cnt;
	}

	public int countIncreasingLen(final int arr[], final int n) {
		int cnt = 0; // Initialize result

		// Initialize length of current increasing
		// subarray
		int len = 1;

		// Traverse through the array
		for (int i = 0; i < (n - 1); ++i) {
			// If arr[i+1] is greater than arr[i],
			// then increment length
			if (arr[i + 1] > arr[i]) {
				len++;
			} else {
				cnt += (((len - 1) * len) / 2);
				len = 1;
			}
		}

		// If last length is more than 1
		if (len > 1) {
			cnt += (((len - 1) * len) / 2);
		}

		return cnt;
	}

	public void spiralPrint(int endingRowIndex, int endingColumnIndex, final int[][] arr) {
		int startingRowIndex = 0;
		int startingColumnIndex = 0;
		int i = 0;
		while ((startingRowIndex < endingRowIndex) && (startingColumnIndex < endingColumnIndex)) {
			for (i = startingColumnIndex; i < endingColumnIndex; ++i) {
				System.out.print(arr[startingRowIndex][i]);
			}
			startingRowIndex++;
			/* Print the last column from the remaining columns */
			for (i = startingRowIndex; i < endingRowIndex; ++i) {
				System.out.print(arr[i][endingColumnIndex - 1]);
			}
			endingColumnIndex--;
			if (startingRowIndex < endingRowIndex) {
				for (i = endingColumnIndex - 1; i >= startingColumnIndex; --i) {
					System.out.print(arr[endingRowIndex - 1][i]);
				}
				endingRowIndex--;
			}
			if (startingColumnIndex < endingColumnIndex) {
				for (i = endingRowIndex - 1; i >= startingRowIndex; --i) {
					System.out.print(arr[i][startingColumnIndex]);
				}
				startingColumnIndex++;
			}

		}

	}

	int search(final int arr[], final int l, final int h, final int key) {
		if (l > h) {
			return -1;
		}

		final int mid = (l + h) / 2;
		if (arr[mid] == key) {
			return mid;
		}

		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in half or other
			 * half
			 */
			if ((key >= arr[l]) && (key <= arr[mid])) {
				return this.search(arr, l, mid - 1, key);
			}

			return this.search(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if ((key >= arr[mid]) && (key <= arr[h])) {
			return this.search(arr, mid + 1, h, key);
		}

		return this.search(arr, l, mid - 1, key);
	}

	static int cutRod(final int price[], final int n) {
		if (n <= 0) {
			return 0;
		}
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++) {
			max_val = Math.max(max_val, price[i] + ArraySolutions.cutRod(price, n - i - 1));
		}

		return max_val;
	}

	static int arr[] = new int[] { 1, 5, 7, -1, 5 };

	// Returns number of pairs in arr[0..n-1] with sum equal
	// to 'sum'
	static int getPairsCount(final int n, final int sum) {
		final HashMap<Integer, Integer> hm = new HashMap<>();

		// Store counts of all elements in map hm
		for (int i = 0; i < n; i++) {

			// initializing value to 0, if key not found
			if (!hm.containsKey(ArraySolutions.arr[i])) {
				hm.put(ArraySolutions.arr[i], 0);
			}

			hm.put(ArraySolutions.arr[i], hm.get(ArraySolutions.arr[i]) + 1);
		}
		int twice_count = 0;

		// iterate through each element and increment the
		// count (Notice that every pair is counted twice)
		for (int i = 0; i < n; i++) {
			if (hm.get(sum - ArraySolutions.arr[i]) != null) {
				twice_count += hm.get(sum - ArraySolutions.arr[i]);
			}

			// if (arr[i], arr[i]) pair satisfies the condition,
			// then we need to ensure that the count is
			// decreased by one such that the (arr[i], arr[i])
			// pair is not considered
			if ((sum - ArraySolutions.arr[i]) == ArraySolutions.arr[i]) {
				twice_count--;
			}
		}

		// return the half of twice_count
		return twice_count / 2;
	}

	// Driver method to test the above function
	public static void main(final String[] args) {

		// System.out.println("Count of pairs is " +
		// ArraySolutions.getPairsCount(ArraySolutions.arr.length, sum));
		final int[] arr = { 1, 6, 2, 3, 1, 3, 6, 6 };
		ArraySolutions.printRepeating(arr, 8);
		ArraySolutions.printFirstRepeating(arr);
	}

	static void printRepeating(final int arr[], final int n) {
		// First check all the values that are
		// present in an array then go to that
		// values as indexes and increment by
		// the size of array
		for (int i = 0; i < n; i++) {
			final int index = arr[i] % n;
			arr[index] += n;
		}

		// Now check which value exists more
		// than once by dividing with the size
		// of array
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				System.out.println(i);

			}
		}
	}

	static void printFirstRepeating(final int arr[]) {
		// Creates an empty hashset
		final HashSet<Integer> set = new HashSet<>();

		// Traverse the input array from right to left
		for (int i = arr.length - 1; i >= 0; i--) {
			// If element is already in hash set, update min
			if (set.contains(arr[i])) {
				System.out.println("The first repeating element is " + arr[i]);
				return;
			} else {
				set.add(arr[i]);
			}
		}
		System.out.println("There are no repeating elements");
	}
}
