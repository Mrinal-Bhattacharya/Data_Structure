package com.interviewbit.binarysearch.treeconstruction;

import java.util.ArrayList;

import com.interviewbit.binarytree.TreeNode;

public class InorderTraversalOfCartesianTree {
	public TreeNode buildTree(final ArrayList<Integer> A) {
		if ((A == null) || (A.size() == 0)) {
			return null;
		}
		final TreeNode root = this.buildTree(A, 0, A.size() - 1);
		return root;
	}

	public TreeNode buildTree(final ArrayList<Integer> A, final int start, final int end) {
		if (start > end) {
			return null;
		}

		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = start; i <= end; i++) {
			if (max < A.get(i)) {
				max = A.get(i);
				maxIndex = i;
			}
		}

		final TreeNode root = new TreeNode(max);

		if (start == end) {
			return root;
		}
		root.left = this.buildTree(A, start, maxIndex - 1);
		root.right = this.buildTree(A, maxIndex + 1, end);
		return root;
	}
}
