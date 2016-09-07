package com.java.ds.basic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeSolutions {

	// Give an algorithm for finding maximum element in binary tree.
	public int maxInBinaryTree(final BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return maxValue;
		}
		final int leftMax = (this.maxInBinaryTree(root.getLeft()));
		final int rightMax = (this.maxInBinaryTree(root.getRight()));
		if (leftMax > rightMax) {
			maxValue = leftMax;
		} else {
			maxValue = rightMax;
		}
		if (root.getData() > maxValue) {
			maxValue = root.getData();
		}
		return maxValue;
	}

	// Give an algorithm for finding maximum element in binary tree without
	// recursion.
	public int maxInBinaryTreeLevelOrder(final BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return maxValue;
		}
		final BinaryTreeNode node = root;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			final BinaryTreeNode temp = q.poll();
			if (temp.getData() > maxValue) {
				maxValue = temp.getData();
			}
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
		}
		return maxValue;
	}

	// Given an algorithm for searching an element in binary tree.
	public boolean findInBT(final BinaryTreeNode root, final int data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			return true;
		}
		return this.findInBT(root.getLeft(), data) || this.findInBT(root.getRight(), data);
	}

	// Given an algorithm for searching an element in binary tree without
	// recursion.
	public boolean findInBTWithoutRecursion(final BinaryTreeNode root, final int data) {
		if (root == null) {
			return false;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if (tmp.getData() == data) {
				return true;
			}
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
		}
		return false;
	}

	// Give an algorithm for finding the size of binary tree
	public int size(final BinaryTreeNode root) {
		final int leftCount = root.getLeft() == null ? 0 : this.size(root.getLeft());
		final int rightCount = root.getRight() == null ? 0 : this.size(root.getRight());
		return 1 + leftCount + rightCount;
	}

	// Give an algorithm for finding the size of binary tree without recursion
	public int sizeWithoutRecursion(final BinaryTreeNode root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			count++;
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
		}
		return count;
	}

	// Give an algorithm for finding the height( or depth) of the binary tree.
	public int maxDepth(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		final int leftDepth = this.maxDepth(root.getLeft());
		final int rightDepth = this.maxDepth(root.getRight());
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}

	// Give an algorithm for finding the height( or depth) of the binary tree
	// with stack.
	public int maxDepthWithStack(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		final Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		int maxDepth = 0;
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			final BinaryTreeNode curr = s.peek();
			if ((prev == null) || (prev.getLeft() == curr) || (prev.getRight() == curr)) {
				if (curr.getLeft() != null) {
					s.push(curr.getLeft());
				} else if (curr.getRight() != null) {
					s.push(curr.getRight());
				}
			} else if (curr.getLeft() == prev) {
				if (curr.getRight() != null) {
					s.push(curr.getRight());
				}
			} else {
				s.pop();
			}
			prev = curr;
			if (s.size() > maxDepth) {
				maxDepth = s.size();
			}

		}
		return maxDepth;
	}

	// Give an algorithm for finding the height( or depth) of the binary tree
	// without recursion.
	public int maxDepthWithoutRecursive(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxDepth = 1;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			} else {
				if (!q.isEmpty()) {
					++maxDepth;
					q.offer(null);
				}
			}
		}
		return maxDepth;

	}

	// Give an algorithm for finding the minimum depth of the binary tree.
	public int minDepth(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if ((tmp.getLeft() == null) && (tmp.getRight() == null)) {
					return count;
				}
				if (tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}

		}
		return count;
	}

	// Give an algorithm to for finding the deepest node of the binary tree.
	public BinaryTreeNode deepestNode(final BinaryTreeNode root) {
		BinaryTreeNode tmp = null;
		if (root == null) {
			return null;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			tmp = q.poll();

			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}

		}
		return tmp;
	}

	// Give an algorithm for finding the number of leaves in the binary tree
	// without using recursion.
	public int numberOfLeavesInBTUsingLevelOrder(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if ((tmp.getLeft() == null) && (tmp.getRight() == null)) {
				count++;
			}
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}

		}
		return count;
	}

	// Give an algorithm for finding the number of full node in the binary tree
	// without using recursion.
	public int numberOfFullNodeInBTUsingLevelOrder(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if ((tmp.getLeft() != null) && (tmp.getRight() != null)) {
				count++;
			}
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}

		}
		return count;
	}

	// Give an algorithm for finding the number of half node in the binary tree
	// without using recursion.
	public int numberOfHalfNodeInBTUsingLevelOrder(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			if (((tmp.getLeft() != null) && (tmp.getRight() == null))
					|| ((tmp.getRight() != null) && (tmp.getLeft() == null))) {
				count++;
			}
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}

		}
		return count;
	}

	// Given two binary tree, return true if they are structurally identical.
	public boolean checkStructurallyIdentical(final BinaryTreeNode root1, final BinaryTreeNode root2) {
		if ((root1 == null) && (root2 == null)) {
			return true;
		}
		if (((root1 == null) && (root2 != null)) || ((root2 == null) && (root2 != null))) {
			return false;
		}
		return this.checkStructurallyIdentical(root1.getLeft(), root2.getLeft())
				&& this.checkStructurallyIdentical(root1.getRight(), root2.getRight());

	}

	public int diameterOfTree(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		final Height h = new Height();
		this.height(root, h);
		return h.ans;
	}

	private int height(final BinaryTreeNode root, final Height h) {
		if (root == null) {
			return 0;
		}
		final int left_height = this.height(root.getLeft(), h);
		final int right_height = this.height(root.getRight(), h);
		// update the answer, because diameter of a
		// tree is nothing but maximum value of
		// (left_height + right_height + 1) for each node
		h.ans = Math.max(h.ans, 1 + left_height + right_height);
		return 1 + Math.max(left_height, right_height);
	}

	public int diameter(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		/* get the height of left and right sub trees */
		final int lheight = this.height(root.getLeft());
		final int rheight = this.height(root.getRight());

		/* get the diameter of left and right subtrees */
		final int ldiameter = this.diameter(root.getLeft());
		final int rdiameter = this.diameter(root.getRight());

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter
		 * of right subtree 3) Height of left subtree + height of right subtree
		 * + 1(Longest path between two nodes which passes through the root.)
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	private int height(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		final int leftDepth = this.height(root.getLeft());
		final int rightDepth = this.height(root.getRight());
		return (1 + Math.max(leftDepth, rightDepth));
	}

	// Give an algorithm for finding the width of the binary tree. The diameter
	// of a tree is the maximum number of nodes at any level (or depth) in the
	// tree.
	// Width of a tree is maximum of widths of all levels.
	public int width(final BinaryTreeNode root) {
		int max = 0;
		final int height = this.maxDepth(root);
		for (int k = 0; k <= height; k++) {
			final int tmp = this.width(root, k);
			if (tmp > max) {
				max = tmp;
			}
		}
		return max;
	}

	private int width(final BinaryTreeNode root, final int depth) {
		if (root == null) {
			return 0;
		}
		if (depth == 0) {
			return 1;
		}
		return this.width(root.getLeft(), depth - 1) + this.width(root.getRight(), depth - 1);

	}

	public int widthUsingQueue(final BinaryTreeNode root) {
		int maxWidth = 0;
		if (root == null) {
			return 0;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			maxWidth = Math.max(maxWidth, q.size());
			final BinaryTreeNode tmp = q.poll();
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
		}
		return maxWidth;
	}
}

class Height {
	int ans;
}