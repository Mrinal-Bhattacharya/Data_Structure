package com.java.ds.basic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeSolutions {

	// In Binary Search Tree, we can find maximum by traversing right pointers
	// until we reach rightmost node. But in Binary Tree, we must visit every
	// node to //figure out maximum

	// Give an algorithm for finding maximum element in binary tree.
	public int maxInBinarySearchTree(final BinaryTreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		BinaryTreeNode current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();
	}

	// Give an algorithm for finding minimum element in binary tree.
	public int minInBinarySearchTree(final BinaryTreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		BinaryTreeNode current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();
	}

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

	// Give an algorithm for finding minimum element in binary tree without
	// recursion.
	public int minInBinaryTreeLevelOrder(final BinaryTreeNode root) {
		int minValue = Integer.MAX_VALUE;
		if (root == null) {
			return minValue;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode temp = q.poll();
			if (temp.getData() < minValue) {
				minValue = temp.getData();
			}
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
		}
		return minValue;
	}

	// Give an algorithm for finding minimum element in binary tree.
	public int findMin(final BinaryTreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int res = root.getData();
		final int lMin = this.findMin(root.getLeft());
		final int rMin = this.findMin(root.getRight());
		if (lMin < res) {
			res = lMin;
		} else {
			res = rMin;
		}
		return res;
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
	// NULL|3|2|NULL|1
	//
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

	public void test(final BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		final Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// level delimiter
		queue.offer(null);

		int maxSum = 0;
		int level = 0;
		// default root level
		int localLevel = 0;
		int localSum = 0;
		while (!queue.isEmpty()) {
			final BinaryTreeNode node = queue.poll();
			// Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
				}

				if (localSum > maxSum) {
					maxSum = localSum;
					level = localLevel;
				}
				// Reset the level sum for next level calculation
				localSum = 0;
				localLevel++;
			} else {
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
				localSum += node.getData();
			}
		}
		System.out.println("Max Sum = " + maxSum + " is at Level = " + level);
	}

	public int findLevelWithMaxSum(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxSum = 0;
		int currentSum = 0;
		int level = 0;
		int localLevel = 0;
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
				currentSum += tmp.getData();
			} else {
				if (!q.isEmpty()) {
					q.offer(null);
				}
				if (currentSum > maxSum) {
					maxSum = currentSum;
					level = localLevel;
				}
				currentSum = 0;
				localLevel++;
			}
			// System.out.println("Max Sum = " + maxSum + " is at Level = " +
			// level);
		}
		System.out.println("Max Sum = " + maxSum + " is at Level = " + level);
		return maxSum;
	}

	// Give an algorithm for checking the existence of path with given sum. That
	// means, given a sum check whether there exists a path from root to any of
	// Nodes.
	// (Root to leaf path sum equal to a given number)
	public boolean hasPathSum(final BinaryTreeNode root, final int sum) {
		if (root == null) {
			return false;
		}
		if ((root.getLeft() == null) && (root.getRight() == null) && (root.getData() == sum)) {
			return true;
		}
		return this.hasPathSum(root.getLeft(), sum - root.getData())
				|| this.hasPathSum(root.getRight(), sum - root.getData());
	}

	// Give an algorithm to find k sum for any path in tree
	public void needToUnderstand() {

	}

	// Give an algorithm for finding the sum of all elements in binary tree
	public int addBT(final BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.getData() + this.addBT(root.getLeft()) + this.addBT(root.getRight());
	}

	// addBTWithout recursion
	public int addBTWithoutRecursion(final BinaryTreeNode root) {
		int sum = 0;
		if (root == null) {
			return 0;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode tmp = q.poll();
			sum += tmp.getData();
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
		}
		return sum;
	}

	// Give an algorithm for converting a tree to its mirror. Mirror of a tree
	// another tree with left and right children of all non leaf nodes
	// interchanged. The threes below are mirrors to each other.
	public BinaryTreeNode mirror(final BinaryTreeNode root) {
		BinaryTreeNode tmp;
		if (root != null) {
			this.mirror(root.getLeft());
			this.mirror(root.getRight());
			tmp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(tmp);
		}
		return root;
	}

	// Given two tree, give an algorithm for checking whether they are mirrors
	// of each other.
	public boolean areMirrors(final BinaryTreeNode root1, final BinaryTreeNode root2) {
		if ((root1 == null) && (root2 == null)) {
			return true;
		}
		if ((root1 == null) || (root2 == null)) {
			return false;
		}
		return (root1.getData() == root2.getData()) && this.areMirrors(root1.getLeft(), root2.getRight())
				&& this.areMirrors(root1.getRight(), root2.getLeft());
	}

	void findSum(final Integer originalSum, final Integer sum, final List<List<Integer>> result,
			final List<Integer> currentList, final BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		final Integer nodeValue = node.getData();
		currentList.add(nodeValue);

		if (Objects.equals(sum, nodeValue)) {
			final List<Integer> resultL = new ArrayList(currentList);
			result.add(resultL);
		}

		this.findSum(originalSum, originalSum, result, new ArrayList(), node.getRight());
		this.findSum(originalSum, originalSum, result, new ArrayList(), node.getLeft());
		final int remaining = sum - nodeValue;
		this.findSum(originalSum, remaining, result, new ArrayList(currentList), node.getLeft());
		this.findSum(originalSum, remaining, result, new ArrayList(currentList), node.getRight());

	}

	static int preIndex = 0;

	/*
	 * Recursive function to construct binary of size len from Inorder traversal
	 * in[] and Preorder traversal pre[]. Initial values of inStrt and inEnd
	 * should be 0 and len -1. The function doesn't do any error checking for
	 * cases where inorder and preorder do not form a tree
	 */
	BinaryTreeNode buildTree(final int in[], final int pre[], final int inStrt, final int inEnd) {
		if (inStrt > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		final BinaryTreeNode tNode = new BinaryTreeNode(pre[BinaryTreeSolutions.preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd) {
			return tNode;
		}

		/* Else find the index of this node in Inorder traversal */
		final int inIndex = this.search(in, inStrt, inEnd, tNode.getData());

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.setLeft(this.buildTree(in, pre, inStrt, inIndex - 1));
		tNode.setRight(this.buildTree(in, pre, inIndex + 1, inEnd));

		return tNode;
	}

	static int postIndex = 4;

	/*
	 * Recursive function to construct binary of size len from Inorder traversal
	 * in[] and Preorder traversal pre[]. Initial values of inStrt and inEnd
	 * should be 0 and len -1. The function doesn't do any error checking for
	 * cases where inorder and preorder do not form a tree
	 */
	public BinaryTreeNode buildTreePost(final int in[], final int post[], final int inStrt, final int inEnd) {
		if (inStrt > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		final BinaryTreeNode tNode = new BinaryTreeNode(post[BinaryTreeSolutions.postIndex--]);

		/* If this node has no children then return */
		if (inStrt == inEnd) {
			return tNode;
		}

		/* Else find the index of this node in Inorder traversal */
		final int inIndex = this.search(in, inStrt, inEnd, tNode.getData());

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.setRight(this.buildTreePost(in, post, inIndex + 1, inEnd));
		tNode.setLeft(this.buildTreePost(in, post, inStrt, inIndex - 1));

		return tNode;
	}

	// This function returns pointer to LCA of two given
	// values n1 and n2. This function assumes that n1 and
	// n2 are present in Binary Tree
	BinaryTreeNode findLCA(final BinaryTreeNode node, final int n1, final int n2) {

		// Base case
		if (node == null) {
			return null;
		}

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if ((node.getData() == n1) || (node.getData() == n2)) {
			return node;
		}

		// Look for keys in left and right subtrees
		final BinaryTreeNode left_lca = this.findLCA(node.getLeft(), n1, n2);
		final BinaryTreeNode right_lca = this.findLCA(node.getRight(), n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if ((left_lca != null) && (right_lca != null)) {
			return node;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	boolean v1 = false, v2 = false;

	private BinaryTreeNode findLCAUtil(final BinaryTreeNode node, final int n1, final int n2) {
		// Base case
		if (node == null) {
			return null;
		}

		// If either n1 or n2 matches with root's key, report the presence
		// by setting v1 or v2 as true and return root (Note that if a key
		// is ancestor of other, then the ancestor key becomes LCA)
		if (node.getData() == n1) {
			this.v1 = true;
			return node;
		}
		if (node.getData() == n2) {
			this.v2 = true;
			return node;
		}

		// Look for keys in left and right subtrees
		final BinaryTreeNode left_lca = this.findLCAUtil(node.getLeft(), n1, n2);
		final BinaryTreeNode right_lca = this.findLCAUtil(node.getRight(), n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if ((left_lca != null) && (right_lca != null)) {
			return node;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	public BinaryTreeNode findLCAHack(final BinaryTreeNode root, final int n1, final int n2) {
		final BinaryTreeNode lca = this.findLCAUtil(root, n1, n2);

		// Return LCA only if both n1 and n2 are present in tree
		if (this.v1 && this.v2) {
			return lca;
		}

		// Else return NULL
		return null;
	}

	public int findLCAInternal(final BinaryTreeNode root, final int n1, final int n2) {
		final List<Integer> path1 = new ArrayList<>();
		final List<Integer> path2 = new ArrayList<>();

		if (!this.findPath(root, n1, path1) || !this.findPath(root, n2, path2)) {
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
			return -1;
		}

		int i;
		for (i = 0; (i < path1.size()) && (i < path2.size()); i++) {
			// System.out.println(path1.get(i) + " " + path2.get(i));
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}

		return path1.get(i - 1);
	}

	private boolean findPath(final BinaryTreeNode root, final int n, final List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.getData());
		if (root.getData() == n) {
			return true;
		}
		if ((root.getLeft() != null) && this.findPath(root.getLeft(), n, path)) {
			return true;
		}
		if ((root.getRight() != null) && this.findPath(root.getRight(), n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Function to find index of value in arr[start...end] The function assumes
	 * that value is present in in[]
	 */
	int search(final int arr[], final int strt, final int end, final int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return i;
	}

	// Give an algorithm for printing, all the ancestors of a node in binary
	// tree.
	public boolean printAllAncestors(final BinaryTreeNode root, final BinaryTreeNode node) {
		if (root == null) {
			return false;
		}
		if ((root.getLeft() == node) || (root.getRight() == node) || this.printAllAncestors(root.getLeft(), node)
				|| this.printAllAncestors(root.getRight(), node)) {
			System.out.println("Ancestors " + root.getData());
			return true;
		}
		return false;
	}

	public void printPath(final BinaryTreeNode root) {
		final int path[] = new int[256];
		this.printPaths(root, path, 0);
	}

	private void printPaths(final BinaryTreeNode root, final int[] path, int pathLen) {
		if (root == null) {
			return;
		}
		path[pathLen] = root.getData();
		pathLen++;
		if ((root.getLeft() == null) && (root.getRight() == null)) {
			this.printArray(path, pathLen);
		}
		this.printPaths(root.getLeft(), path, pathLen);
		this.printPaths(root.getRight(), path, pathLen);
	}

	private void printArray(final int[] path, final int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.print(path[i]);
		}
		System.out.println();
	}

	/*
	 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
	 */

	public void printSpiral(final BinaryTreeNode node) {
		System.out.println("===========ZigZag=================");
		final int h = this.height(node);
		int i;

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * transversed from left to right
		 */
		boolean ltr = false;
		for (i = 1; i <= h; i++) {
			this.printGivenLevel(node, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
		}

	}

	/* Print nodes at a given level */
	void printGivenLevel(final BinaryTreeNode node, final int level, final boolean ltr) {
		if (node == null) {
			return;
		}
		if (level == 1) {
			System.out.print(node.getData() + " ");
		} else if (level > 1) {
			if (ltr != false) {
				this.printGivenLevel(node.getLeft(), level - 1, ltr);
				this.printGivenLevel(node.getRight(), level - 1, ltr);
			} else {
				this.printGivenLevel(node.getRight(), level - 1, ltr);
				this.printGivenLevel(node.getLeft(), level - 1, ltr);
			}
		}
	}

	public void printSpiralStack(final BinaryTreeNode node) {
		if (node == null) {
			return; // NULL check
		}

		// Create two stacks to store alternate levels
		final Stack<BinaryTreeNode> s1 = new Stack<>();
		// For levels to be printed from right to left
		final Stack<BinaryTreeNode> s2 = new Stack<>();
		// For levels to be printed from left to right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep ptinting while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				final BinaryTreeNode temp = s1.peek();
				s1.pop();
				System.out.print(temp.getData() + " ");

				// Note that is right is pushed before left
				if (temp.getRight() != null) {
					s2.push(temp.getRight());
				}

				if (temp.getLeft() != null) {
					s2.push(temp.getLeft());
				}

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				final BinaryTreeNode temp = s2.peek();
				s2.pop();
				System.out.print(temp.getData() + " ");

				// Note that is left is pushed before right
				if (temp.getLeft() != null) {
					s1.push(temp.getLeft());
				}
				if (temp.getRight() != null) {
					s1.push(temp.getRight());
				}
			}
		}
		System.out.println();
	}

	// Given a Binary Tree, find vertical sum of the nodes that are in same
	// vertical line. Print all sums through different vertical lines.
	// We need to check the Horizontal Distances from root for all nodes. If two
	// nodes have the same Horizontal Distance (HD), then they are on same
	// vertical line. The idea of HD is simple. HD for root is 0, a right edge
	// (edge connecting to right subtree) is considered as +1 horizontal
	// distance and a left edge is considered as -1 horizontal distance.
	// For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is
	// -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
	public void sumVertical(final BinaryTreeNode root) {
		System.out.println("===========Vertical Sum=================");
		final Map<Integer, Integer> verticalSumMap = new HashMap<>();
		final int horizontalDistance = 0;
		this.verticalSum(root, verticalSumMap, horizontalDistance);
		System.out.println(verticalSumMap.entrySet());
	}

	private void verticalSum(final BinaryTreeNode root, final Map<Integer, Integer> verticalSumMap,
			final int horizontalDistance) {
		if (root == null) {
			return;
		}
		if (root.getLeft() != null) {
			this.verticalSum(root.getLeft(), verticalSumMap, horizontalDistance - 1);
		}
		if (root.getRight() != null) {
			this.verticalSum(root.getRight(), verticalSumMap, horizontalDistance + 1);
		}
		final int prevSum = verticalSumMap.get(horizontalDistance) == null ? 0 : verticalSumMap.get(horizontalDistance);
		verticalSumMap.put(horizontalDistance, prevSum + root.getData());

	}

	// Construct all possible BSTs for keys 1 to N
	public ArrayList<BinaryTreeNode> generateTrees(final int n) {
		if (n == 0) {
			return this.generateTrees(1, 0);
		}
		return this.generateTrees(1, n);
	}

	private ArrayList<BinaryTreeNode> generateTrees(final int start, final int end) {
		final ArrayList<BinaryTreeNode> subTrees = new ArrayList<>();
		if (start > end) {
			subTrees.add(null);
			return subTrees;
		}
		for (int i = start; i <= end; i++) {
			final ArrayList<BinaryTreeNode> lefts = this.generateTrees(start, i - 1);
			final ArrayList<BinaryTreeNode> rights = this.generateTrees(i + 1, end);
			for (final BinaryTreeNode left : lefts) {
				for (final BinaryTreeNode right : rights) {
					final BinaryTreeNode node = new BinaryTreeNode(i);
					node.setLeft(left);
					node.setRight(right);
					subTrees.add(node);
				}
			}
		}
		return subTrees;
	}

	// Given a tree with special property where leaves are represented with 'L'
	// and internal node with "i". Also, assume that each node has either 0 or 2
	// children. Given preorder traversal of this tree, construct the tree.
	// Example: Given preorder strong => ILILL
	public BinaryTreeNode buildTreeFromPreOrder(final char[] a, int i) {
		if (a == null) {
			return null;
		}
		if (a.length == i) {
			return null;
		}
		final BinaryTreeNode node = new BinaryTreeNode(a[i]);
		if (a[i] == 'L') {
			return node;
		}
		i = i + 1;
		node.setLeft(this.buildTreeFromPreOrder(a, i));
		i = i + 1;
		node.setRight(this.buildTreeFromPreOrder(a, i));
		return node;
	}

	public void fillNextSiblings(final SiblingBinaryTreeNode root) {
		if (root == null) {
			return;
		}
		SiblingBinaryTreeNode tmp = null;
		final Queue<SiblingBinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			tmp = q.poll();
			if (tmp != null) {
				tmp.setNextSibling(q.peek());
				if (tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			} else {
				if (!q.isEmpty()) {
					q.offer(null);
				}
			}
		}
	}

}

class Height {
	int ans;
}