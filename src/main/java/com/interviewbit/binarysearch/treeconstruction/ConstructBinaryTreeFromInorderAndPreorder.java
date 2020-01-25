package com.interviewbit.binarysearch.treeconstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.interviewbit.binarytree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPreorder {
	public TreeNode buildTree(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		final Map<Integer, Integer> inOrderPos = new HashMap<>();
		for (int i = 0; i < B.size(); i++) {
			inOrderPos.put(B.get(i), i);
		}
		return this.buildTreeHelper(A, 0, A.size() - 1, B, 0, B.size() - 1, inOrderPos);
	}

	private TreeNode buildTreeHelper(final ArrayList<Integer> preOrder, final int pLeft, final int pRight,
			final ArrayList<Integer> inOrder, final int iLeft, final int iRight,
			final Map<Integer, Integer> inOrderPos) {
		if ((pLeft > pRight) || (iLeft > iRight)) {
			return null;
		}
		final int i = inOrderPos.get(preOrder.get(pLeft));
		final TreeNode root = new TreeNode(preOrder.get(pLeft));
		root.left = this.buildTreeHelper(preOrder, pLeft + 1, (pLeft + i) - iLeft, inOrder, iLeft, i - 1, inOrderPos);
		root.right = this.buildTreeHelper(preOrder, ((pLeft + i) - iLeft) + 1, pRight, inOrder, i + 1, iRight,
				inOrderPos);
		return root;
	}

	int pIndex = 0;

	public TreeNode buildTree2(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		final Map<Integer, Integer> inOrderPos = new HashMap<>();
		this.pIndex = 0;
		for (int i = 0; i < B.size(); i++) {
			inOrderPos.put(B.get(i), i);
		}
		return this.createTree(A, B, 0, B.size() - 1, inOrderPos);
	}

	public TreeNode createTree(final ArrayList<Integer> preorder, final ArrayList<Integer> inorder, final int start,
			final int end, final Map<Integer, Integer> inOrderPos) {

		if (start > end) {
			return null;
		}

		final TreeNode node = new TreeNode(preorder.get(this.pIndex++));
		if (start == end) {
			return node;
		}

		final int inIndex = inOrderPos.get(node.val);

		node.left = this.createTree(preorder, inorder, start, inIndex - 1, inOrderPos);
		node.right = this.createTree(preorder, inorder, inIndex + 1, end, inOrderPos);
		return node;
	}
}
