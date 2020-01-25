package com.interviewbit.binarysearch.treeconstruction;

import com.interviewbit.binarytree.TreeNode;

public class SortedArrayToBalancedBST {
	public TreeNode sortedArrayToBST(final int[] a) {
		return this.constructBST(a, 0, a.length - 1);
	}

	public TreeNode constructBST(final int[] a, final int start, final int end) {
		if (start > end) {
			return null;
		}

		final int mid = (start + end) / 2;
		final TreeNode root = new TreeNode(a[mid]);

		root.left = this.constructBST(a, start, mid - 1);
		root.right = this.constructBST(a, mid + 1, end);

		return root;
	}

	public static void main(final String[] args) {
		final int[] a = { 1 };
		new SortedArrayToBalancedBST().sortedArrayToBST(a);
	}
}
