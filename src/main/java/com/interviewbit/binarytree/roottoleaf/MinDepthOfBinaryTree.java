package com.interviewbit.binarytree.roottoleaf;

import com.interviewbit.binarytree.TreeNode;

public class MinDepthOfBinaryTree {
	public int minDepth(final TreeNode A) {
		if (A == null) {
			return 0;
		}
		if ((A.left == null) && (A.right != null)) {
			return 1 + this.minDepth(A.right);
		}
		if ((A.left != null) && (A.right == null)) {
			return 1 + this.minDepth(A.left);
		}

		return 1 + Math.min(this.minDepth(A.left), this.minDepth(A.right));
	}
}
