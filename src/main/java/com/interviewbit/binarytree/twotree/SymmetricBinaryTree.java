package com.interviewbit.binarytree.twotree;

import com.interviewbit.binarytree.TreeNode;

public class SymmetricBinaryTree {
	public int isSymmetric(final TreeNode A) {
		if (A == null) {
			return 1;
		}

		return this.areNodeSymmetric(A.left, A.right) == true ? 1 : 0;
	}

	public boolean areNodeSymmetric(final TreeNode node1, final TreeNode node2) {
		if ((node1 == null) && (node2 == null)) {
			return true;
		}
		if (((node1 == null) && (node2 != null)) || ((node1 != null) && (node2 == null))) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}

		return this.areNodeSymmetric(node1.left, node2.right) && this.areNodeSymmetric(node1.right, node2.left);
	}
}
