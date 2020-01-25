package com.interviewbit.binarytree.roottoleaf;

import com.interviewbit.binarytree.TreeNode;

public class MaxDepthOfBinaryTree {
	public int maxDepth(final TreeNode A) {
		if (A == null) {
			return 0;
		}
		return Math.max(this.maxDepth(A.left) + 1, this.maxDepth(A.right) + 1);
	}
}
