package com.interviewbit.binarytree.roottoleaf;

import com.interviewbit.binarytree.TreeNode;

public class SumRootToLeafNumbers {
	private static final int MOD = 1003;

	public int sumNumbers(final TreeNode A) {
		return this.sum(A, 0) % SumRootToLeafNumbers.MOD;
	}

	public int sum(final TreeNode root, final int mul) {

		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return ((mul * 10) + root.val) % SumRootToLeafNumbers.MOD;
		}

		int num = (mul * 10) + root.val;
		num %= SumRootToLeafNumbers.MOD;
		final int ans = (this.sum(root.left, num) + this.sum(root.right, num));

		return ans % 1003;
	}
}
