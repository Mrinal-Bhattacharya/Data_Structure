package com.interviewbit.binarytree.bsttraversal;

import com.interviewbit.binarytree.TreeNode;

public class MorrisTraversal {
	void traversal(final TreeNode root) {
		TreeNode current, pre;
		if (root == null) {
			return;
		}
		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.val);
				current = current.right;
			} else {
				pre = current.left;
				while ((pre.right != null) && (pre.right != current)) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
	}

	public static void main(final String[] args) {
		// TreeNode tree = new TreeNode();
		final TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		new MorrisTraversal().traversal(root);
	}
}
