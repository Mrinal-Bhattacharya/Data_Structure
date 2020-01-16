package com.interviewbit.binarysearch.twotree;

import com.interviewbit.binarytree.TreeNode;

public class IdenticalBinaryTrees {
	public int isSameTree(final TreeNode a, final TreeNode b) {
		if ((a == null) && (b == null)) {
			return 1;
		} else if (((a != null) && (b == null)) || ((a == null) && (b != null))) {
			return 0;
		} else if ((a.val == b.val) && (this.isSameTree(a.left, b.left) == 1)
				&& (this.isSameTree(a.right, b.right) == 1)) {
			return 1;
		} else {
			return 0;
		}
	}
}
