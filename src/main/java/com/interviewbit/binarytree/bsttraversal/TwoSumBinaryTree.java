package com.interviewbit.binarytree.bsttraversal;

import com.interviewbit.binarytree.TreeNode;

import java.util.HashSet;

public class TwoSumBinaryTree {
	public int t2Sum(final TreeNode A, final int B) {
		final HashSet<Integer> set = new HashSet<>();
		return this.findpairUtil(A, B, set);
	}

	int findpairUtil(final TreeNode root, final int sum, final HashSet<Integer> set) {
		if (root == null) {
			return 0;
		}

		if (this.findpairUtil(root.left, sum, set) == 1) {
			return 1;
		}

		if (set.contains(sum - root.val)) {
			return 1;
		} else {
			set.add(root.val);
		}

		return this.findpairUtil(root.right, sum, set);
	}
}
