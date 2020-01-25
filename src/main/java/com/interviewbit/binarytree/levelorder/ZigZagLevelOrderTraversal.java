package com.interviewbit.binarytree.levelorder;

import java.util.ArrayList;
import java.util.Stack;

import com.interviewbit.binarytree.TreeNode;

public class ZigZagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(final TreeNode A) {
		final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Stack<TreeNode> currentLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		if (A == null) {
			return result;
		}
		boolean leftToRight = true;
		currentLevel.push(A);
		ArrayList<Integer> list = new ArrayList<>();
		while (!currentLevel.isEmpty()) {
			final TreeNode node = currentLevel.pop();
			list.add(node.val);
			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}

				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}

				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}
			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				final Stack<TreeNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
				result.add(list);
				list = new ArrayList<>();
			}
		}
		return result;

	}

	public static void main(final String[] args) {
		final TreeNode root = new TreeNode(3);
		final TreeNode left = new TreeNode(9);
		final TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		final TreeNode rightLeft = new TreeNode(15);
		final TreeNode rightRight = new TreeNode(7);
		right.left = rightLeft;
		right.right = rightRight;
		new ZigZagLevelOrderTraversal().zigzagLevelOrder(root);
	}
}
