package com.interviewbit.binarytree.traversal;

import java.util.ArrayList;

import com.interviewbit.binarytree.TreeNode;

public class Solutions {
	public ArrayList<Integer> inorderTraversal(final TreeNode A) {
		final ArrayList<Integer> ans = new ArrayList<>();
		this.inorderTraversalHelper(A, ans);
		return ans;
	}

	public void inorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
		if (node != null) {
			this.inorderTraversalHelper(node.left, ans);
			ans.add(node.val);
			this.inorderTraversalHelper(node.right, ans);
		}
	}

	public ArrayList<Integer> postorderTraversal(final TreeNode A) {
		final ArrayList<Integer> ans = new ArrayList<>();
		this.postorderTraversalHelper(A, ans);
		return ans;
	}

	public void postorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
		if (node != null) {
			this.postorderTraversalHelper(node.left, ans);
			this.postorderTraversalHelper(node.right, ans);
			ans.add(node.val);
		}
	}

	public ArrayList<Integer> preorderTraversal(final TreeNode A) {
		final ArrayList<Integer> ans = new ArrayList<>();
		this.preorderTraversalHelper(A, ans);
		return ans;
	}

	public void preorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
		if (node != null) {
			ans.add(node.val);
			this.preorderTraversalHelper(node.left, ans);
			this.preorderTraversalHelper(node.right, ans);
		}
	}
}
