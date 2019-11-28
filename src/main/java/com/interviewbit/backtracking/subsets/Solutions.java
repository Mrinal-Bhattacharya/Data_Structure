package com.interviewbit.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	public ArrayList<ArrayList<Integer>> subsets(final ArrayList<Integer> A) {
		final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		output.add(new ArrayList<Integer>());
		if (A.size() == 0) {
			return output;
		}

		Collections.sort(A);
		this.generate(A, output, new ArrayList<Integer>(), 0);
		return output;
	}

	public void generate(final ArrayList<Integer> a, final ArrayList<ArrayList<Integer>> output,
			final ArrayList<Integer> temp, final int index) {
		for (int i = index; i < a.size(); i++) {
			temp.add(a.get(i));
			output.add(new ArrayList<>(temp));
			this.generate(a, output, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(final ArrayList<Integer> A) {
		final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		output.add(new ArrayList<Integer>());
		if (A.size() == 0) {
			return output;
		}

		Collections.sort(A);
		this.subsetsWithDupHelper(A, output, new ArrayList<Integer>(), 0);
		return output;
	}

	public void subsetsWithDupHelper(final ArrayList<Integer> a, final ArrayList<ArrayList<Integer>> output,
			final ArrayList<Integer> temp, final int index) {
		for (int i = index; i < a.size(); i++) {
			temp.add(a.get(i));
			if (!output.contains(temp)) {
				output.add(new ArrayList<>(temp));
			}
			this.subsetsWithDupHelper(a, output, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> combine(final int A, final int B) {
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (A < B) {
			return ans;
		}

		final ArrayList<Integer> temp = new ArrayList<>();
		this.combineHelper(A, B, ans, temp, 1);
		return ans;
	}

	private void combineHelper(final int a, final int b, final ArrayList<ArrayList<Integer>> ans,
			final ArrayList<Integer> temp, final int start) {
		// this block is just for performance improvement, we can remove this if block
		if (temp.size() > b) {
			return;
		}
		if ((temp.size() == b)) {
			ans.add(new ArrayList<>(temp));
		}
		for (int i = start; i <= a; i++) {
			if (temp.contains(i)) {
				continue;
			}
			// Choose
			temp.add(i);
			// Explore
			this.combineHelper(a, b, ans, temp, i + 1);
			// Un-choose
			temp.remove(temp.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(final ArrayList<Integer> A, final int B) {
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (A.size() == 0) {
			return ans;
		}

		Collections.sort(A);
		final ArrayList<Integer> temp = new ArrayList<>();
		this.combinationSumHelper(A, B, ans, temp, 0);

		return ans;
	}

	private void combinationSumHelper(final ArrayList<Integer> a, final int b, final ArrayList<ArrayList<Integer>> ans,
			final ArrayList<Integer> temp, final int start) {
		if (b < 0) {
			return;
		}
		if ((b == 0) && !ans.contains(temp)) {
			ans.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < a.size(); i++) {
				// Choose
				temp.add(a.get(i));
				// Explore
				this.combinationSumHelper(a, b - a.get(i), ans, temp, i);
				// Un-choose
				temp.remove(temp.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(final ArrayList<Integer> A, final int B) {
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (A.size() == 0) {
			return ans;
		}

		Collections.sort(A);
		final ArrayList<Integer> temp = new ArrayList<>();
		this.combinationSumHelper2(A, B, ans, temp, 0);

		return ans;
	}

	private void combinationSumHelper2(final ArrayList<Integer> a, final int b, final ArrayList<ArrayList<Integer>> ans,
			final ArrayList<Integer> temp, final int start) {
		if (b < 0) {
			return;
		}

		if ((b == 0) && !ans.contains(temp)) {
			ans.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < a.size(); i++) {
				// Choose
				temp.add(a.get(i));
				// Explore
				this.combinationSumHelper(a, b - a.get(i), ans, temp, i + 1);
				// Un-choose
				temp.remove(temp.size() - 1);
			}
		}
	}
}
