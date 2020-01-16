package com.interviewbit.binarytree.ops;

import com.interviewbit.binarytree.TreeNode;

public class Solutions {
	public int height(final TreeNode A) {
		if (A == null) {
			return 0;
		}
		return 1 + Math.max(this.height(A.left), this.height(A.right));
	}

	public int isBalanced(final TreeNode A) {
		if (A == null) {
			return 1;
		}
		if (Math.abs(this.height(A.left) - this.height(A.right)) > 1) {
			return 0;
		}

		return Math.min(this.isBalanced(A.left), this.isBalanced(A.right));
	}
}
