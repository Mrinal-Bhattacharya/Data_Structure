package com.interviewbit.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	private void permutationHelper(final ArrayList<Integer> a, final ArrayList<ArrayList<Integer>> result,
			final ArrayList<Integer> currentList) {

		if (a.size() == 0) {
			result.add(new ArrayList<>(currentList));
			return;
		}

		for (int i = 0; i < a.size(); i++) {

			final int current = a.remove(i);
			System.out.println(current);
			currentList.add(current);
			this.permutationHelper(a, result, currentList);
			System.out.println("-->>>" + i);
			a.add(i, new Integer(current));
			System.out.println("XXCXXXX " + currentList.size());
			currentList.remove(currentList.remove(currentList.size() - 1));
		}
	}

	public ArrayList<ArrayList<Integer>> permute(final ArrayList<Integer> a) {
		if (a == null) {
			return null;
		}

		final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		this.permutationHelper(a, result, new ArrayList<>());
		return result;

	}

    public static void main(final String[] args) throws Exception {
		final Permutations p = new Permutations();
		final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(p.permute(list));
	}
}
