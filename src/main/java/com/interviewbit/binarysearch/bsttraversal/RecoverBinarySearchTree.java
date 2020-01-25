package com.interviewbit.binarysearch.bsttraversal;

import java.util.ArrayList;
import java.util.Collections;

import com.interviewbit.binarytree.TreeNode;

public class RecoverBinarySearchTree {
	ArrayList<Integer> result = new ArrayList<>();
	TreeNode pre = null;
	TreeNode first = null;
	TreeNode middle = null;
	TreeNode last = null;
	TreeNode prev = null;

	public ArrayList<Integer> recoverTree(final TreeNode a) {

		this.recoverTreeHelper(a);
		this.result.add(this.first.val);
		this.result.add(this.last.val);
		Collections.sort(this.result);
		return this.result;
	}

	public void recoverTreeHelper(final TreeNode node) {
		if (node == null) {
			return;
		} else {
			this.recoverTreeHelper(node.left);
			if (this.pre == null) {
				this.pre = node;
			} else {
				if (this.pre.val > node.val) {
					if (this.first == null) {
						this.first = this.pre;
					}
					this.last = node;
				}
				this.pre = node;
			}

			this.recoverTreeHelper(node.right);
		}
	}

	void correctBST(final TreeNode root) {
		// Initialize pointers needed for correctBSTUtil()
		this.first = this.middle = this.last = this.prev = null;

		// Set the poiters to find out two nodes
		this.correctBSTUtil(root);
		// Fix (or correct) the tree
		if ((this.first != null) && (this.last != null)) {
			final int temp = this.first.val;
			this.first.val = this.last.val;
			this.last.val = temp;
		}
		// Adjacent nodes swapped
		else if ((this.first != null) && (this.middle != null)) {
			final int temp = this.first.val;
			this.first.val = this.middle.val;
			this.middle.val = temp;
		}
		// else nodes have not been swapped, passed tree is really BST.
	}

	void correctBSTUtil(final TreeNode root) {
		if (root != null) {
			// Recur for the left subtree
			this.correctBSTUtil(root.left);

			// If this node is smaller than the previous node, it's violating the BST rule.
			if ((this.prev != null) && (root.val < this.prev.val)) {
				// If this is first violation, mark these two nodes as 'first' and 'middle'
				if (this.first == null) {
					this.first = this.prev;
					this.middle = root;
				} else {
					this.last = root;
				}
			}

			// Mark this node as previous
			this.prev = root;
			// Recur for the right subtree
			this.correctBSTUtil(root.right);
		}
	}
}
