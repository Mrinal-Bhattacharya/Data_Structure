package com.interviewbit.binarysearch.inplacechange;

import com.interviewbit.binarytree.TreeNode;

public class InvertTheBinaryTree {
	public TreeNode invertTree(final TreeNode A) {
		if (null == A) {
			return null;
		}

		// LRP, post order traversal
		this.invertTree(A.left);
		this.invertTree(A.right);
		// swap left & right subtree
		final TreeNode tmp = A.left;
		A.left = A.right;
		A.right = tmp;

		return A;
	}
}
