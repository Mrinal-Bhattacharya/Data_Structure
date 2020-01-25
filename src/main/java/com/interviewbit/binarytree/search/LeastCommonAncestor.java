package com.interviewbit.binarytree.search;

import java.util.ArrayList;

import com.interviewbit.binarytree.TreeNode;

public class LeastCommonAncestor {
	public int BSTlca(TreeNode A, final int B, final int C) {
		while (A != null) {
			// If both n1 and n2 are smaller
			// than root, then LCA lies in left
			if ((A.val > B) && (A.val > C)) {
				A = A.left;
			} else if ((A.val < B) && (A.val < C)) {
				A = A.right;
			} else {
				break;
			}
		}
		return A.val;
	}

	int BSTlca2(final TreeNode node, final int n1, final int n2) {
		if (node == null) {
			return -1;
		}

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if ((node.val > n1) && (node.val > n2)) {
			return this.BSTlca2(node.left, n1, n2);
		}

		// If both n1 and n2 are greater than root, then LCA lies in right
		if ((node.val < n1) && (node.val < n2)) {
			return this.BSTlca2(node.right, n1, n2);
		}

		return node.val;
	}

	public int lca(TreeNode a, final int val1, final int val2) {

		a = this.findLCA(a, val1, val2);
		if (a == null) {
			return -1;
		}
		return a.val;

	}

	public TreeNode findLCA(final TreeNode node, final int val1, final int val2) {
		if (node == null) {
			return null;
		}
		if ((node.val == val1) || (node.val == val2)) {
			return node;
		}

		final TreeNode leftLCA = this.findLCA(node.left, val1, val2);
		final TreeNode rightLCA = this.findLCA(node.right, val1, val2);

		if ((leftLCA != null) && (rightLCA != null)) {
			return node;
		}

		return (leftLCA != null) ? leftLCA : rightLCA;

	}

	public int lcaList(final TreeNode a, final int val1, final int val2) {
		final ArrayList<Integer> path1 = new ArrayList<>();
		final ArrayList<Integer> path2 = new ArrayList<>();
		if (!this.findPath(a, path1, val1) || !this.findPath(a, path2, val2)) {
			return -1;
		}
		int i = 0;
		for (i = 0; (i < path1.size()) && (i < path2.size()); i++) {
			if (path1.get(i) != path2.get(i)) {
				break;
			}
		}
		return path1.get(i - 1);
	}

	public boolean findPath(final TreeNode node, final ArrayList<Integer> path, final int val) {
		if (node == null) {
			return false;
		}
		path.add(node.val);
		if (node.val == val) {
			return true;
		}
		if (((node.left != null) && this.findPath(node.left, path, val))
				|| ((node.right != null) && this.findPath(node.right, path, val))) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}
}
