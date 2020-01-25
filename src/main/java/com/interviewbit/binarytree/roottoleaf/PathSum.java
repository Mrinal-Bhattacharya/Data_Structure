package com.interviewbit.binarytree.roottoleaf;

import com.interviewbit.binarytree.TreeNode;

public class PathSum {
	public int hasPathSum(final TreeNode A, int B) {
		if (A == null) {
			return 0;
		}

		if ((A.left == null) && (A.right == null)) {
			return (B - A.val) == 0 ? 1 : 0;
		}

		B -= A.val;

		return Math.max(this.hasPathSum(A.left, B), this.hasPathSum(A.right, B));
	}

	public int hasPathSum2(final TreeNode A, final int B) {
		if (A == null) {
			return 0;
		}
		if ((A.val == B) && (A.left == null) && (A.right == null)) {
			return 1;
		}
		return this.hasPathSum(A.left, B - A.val) | this.hasPathSum(A.right, B - A.val);
	}
}
