package com.interviewbit.binarysearch.treeconstruction;

import java.util.ArrayList;
import java.util.List;

import com.interviewbit.binarytree.TreeNode;

public class BinaryTreeFromInorderAndPostorder {
	public TreeNode buildTree(final List<Integer> A, final List<Integer> B) {
		return this.buildTreeHelper(A, 0, A.size(), B, B.size());
	}

	private TreeNode buildTreeHelper(final List<Integer> inOrder, final int inStart, final int inEnd,
			final List<Integer> postOrder, final int posEnd) {
		if ((posEnd < 0) || (inStart > inEnd)) {
			return null;
		}
		final TreeNode root = new TreeNode(postOrder.get(posEnd));
		int i = inStart;
		for (; i < inEnd; i++) {
			if (inOrder.get(i) == root.val) {
				break;
			}
		}
		root.left = this.buildTreeHelper(inOrder, inStart, i - 1, postOrder, ((posEnd - 1) + i) - inEnd);
		root.right = this.buildTreeHelper(inOrder, i + 1, inEnd, postOrder, posEnd - 1);
		return null;
	}

	int postOrderRoot;

	public TreeNode buildTree(final ArrayList<Integer> inOrder, final ArrayList<Integer> postOrder) {
		this.postOrderRoot = postOrder.size() - 1;
		return this.buildTree(inOrder, postOrder, 0, inOrder.size() - 1);
	}

	public TreeNode buildTree(final ArrayList<Integer> inOrder, final ArrayList<Integer> postOrder, final int inStart,
			final int inEnd) {
		if (inEnd < inStart) {
			return null;
		}
		final int index = this.findVal(inOrder, inStart, inEnd, postOrder.get(this.postOrderRoot--));

		final TreeNode node = new TreeNode(inOrder.get(index));
		node.right = this.buildTree(inOrder, postOrder, index + 1, inEnd);
		node.left = this.buildTree(inOrder, postOrder, inStart, index - 1);
		return node;
	}

	public int findVal(final ArrayList<Integer> A, final int a, final int b, final int key) {
		for (int i = a; i <= b; i++) {
			if (key == A.get(i)) {
				return i;
			}
		}
		return -1;
	}
}
