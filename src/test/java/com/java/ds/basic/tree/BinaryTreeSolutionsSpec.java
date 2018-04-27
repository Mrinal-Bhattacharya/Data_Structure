package com.java.ds.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeSolutionsSpec {

	BinaryTreeNode root = null;

	// -----------------1
	// -----------2-----------3
	// -------4------5--- 6------ 7

	@Before
	public void setUp() {
		this.root = new BinaryTreeNode(1);
		final BinaryTreeNode left = new BinaryTreeNode(2);
		final BinaryTreeNode right = new BinaryTreeNode(3);
		final BinaryTreeNode leftOf2 = new BinaryTreeNode(4);
		final BinaryTreeNode rightOf2 = new BinaryTreeNode(5);
		left.setLeft(leftOf2);
		left.setRight(rightOf2);
		final BinaryTreeNode leftOf3 = new BinaryTreeNode(6);
		final BinaryTreeNode rightOf3 = new BinaryTreeNode(7);
		right.setLeft(leftOf3);
		right.setRight(rightOf3);
		this.root.setLeft(left);
		this.root.setRight(right);
	}

	@Test
	public void testMaxInBinaryTree() {
		Assertions.assertThat(new BinaryTreeSolutions().maxInBinaryTree(this.root)).isEqualTo(7);
	}

	@Test
	public void testMaxInBinaryTreeLevelOrder() {
		Assertions.assertThat(new BinaryTreeSolutions().maxInBinaryTreeLevelOrder(this.root)).isEqualTo(7);
	}

	@Test
	public void testTreeSize() {
		Assertions.assertThat(new BinaryTreeSolutions().size(this.root)).isEqualTo(7);
		Assertions.assertThat(new BinaryTreeSolutions().sizeWithoutRecursion(this.root)).isEqualTo(7);
	}

	@Test
	public void testTreeDepthOrHeight() {
		Assertions.assertThat(new BinaryTreeSolutions().maxDepth(this.root)).isEqualTo(3);
		Assertions.assertThat(new BinaryTreeSolutions().maxDepthWithStack(this.root)).isEqualTo(3);
		Assertions.assertThat(new BinaryTreeSolutions().maxDepthWithoutRecursive(this.root)).isEqualTo(3);
	}

	@Test
	public void testTreeMinDepthOrHeight() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		final BinaryTreeNode left = new BinaryTreeNode(2);
		final BinaryTreeNode right = new BinaryTreeNode(3);
		final BinaryTreeNode leftOf2 = new BinaryTreeNode(4);
		left.setLeft(leftOf2);
		root.setLeft(left);
		root.setRight(right);
		Assertions.assertThat(new BinaryTreeSolutions().minDepth(root)).isEqualTo(2);
		Assertions.assertThat(new BinaryTreeSolutions().maxDepthWithoutRecursive(root)).isEqualTo(3);
	}

	@Test
	public void countTreeLeaveNodes() {
		Assertions.assertThat(new BinaryTreeSolutions().numberOfLeavesInBTUsingLevelOrder(this.root)).isEqualTo(4);
	}

	@Test
	public void countTreeFullNodes() {
		Assertions.assertThat(new BinaryTreeSolutions().numberOfFullNodeInBTUsingLevelOrder(this.root)).isEqualTo(3);
	}

	@Test
	public void countTreeHalfNodes() {
		Assertions.assertThat(new BinaryTreeSolutions().numberOfHalfNodeInBTUsingLevelOrder(this.root)).isEqualTo(0);
	}

	@Test
	public void testDiameter() {
		Assertions.assertThat(new BinaryTreeSolutions().diameterOfTree(this.root)).isEqualTo(5);
		Assertions.assertThat(new BinaryTreeSolutions().diameter(this.root)).isEqualTo(5);
	}

	@Test
	public void testWidth() {
		// Width is different from diameter. Width mean nodes in level whatever
		// is level have maximum node that is width. Diameter is longest path
		// can include or exclude root.
		Assertions.assertThat(new BinaryTreeSolutions().width(this.root)).isEqualTo(4);
		Assertions.assertThat(new BinaryTreeSolutions().widthUsingQueue(this.root)).isEqualTo(4);
	}

	@Test
	public void testWidthMaxSum() {
		Assertions.assertThat(new BinaryTreeSolutions().findLevelWithMaxSum(this.root)).isEqualTo(22);
	}

	@Test
	public void testhasPathSum() {
		Assertions.assertThat(new BinaryTreeSolutions().hasPathSum(this.root, 7)).isTrue();
	}

	@Test
	public void tesAddBT() {
		Assertions.assertThat(new BinaryTreeSolutions().addBT(this.root)).isEqualTo(28);
		Assertions.assertThat(new BinaryTreeSolutions().addBTWithoutRecursion(this.root)).isEqualTo(28);
	}

	@Test
	public void checkMirror() {
		final BinaryTreeNode root1 = new BinaryTreeNode(1);
		final BinaryTreeNode left1 = new BinaryTreeNode(2);
		final BinaryTreeNode right1 = new BinaryTreeNode(3);
		final BinaryTreeNode left1Of2 = new BinaryTreeNode(4);
		final BinaryTreeNode right1Of2 = new BinaryTreeNode(5);
		left1.setLeft(left1Of2);
		left1.setRight(right1Of2);
		root1.setLeft(left1);
		root1.setRight(right1);

		final BinaryTreeNode root2 = new BinaryTreeNode(1);
		final BinaryTreeNode left2 = new BinaryTreeNode(3);
		final BinaryTreeNode right2 = new BinaryTreeNode(2);
		final BinaryTreeNode left2Of2 = new BinaryTreeNode(5);
		final BinaryTreeNode right2Of2 = new BinaryTreeNode(4);
		right2.setLeft(left2Of2);
		right2.setRight(right2Of2);
		root2.setLeft(left2);
		root2.setRight(right2);

		// new BinaryTreeSolutions().mirror(root1);
		Assertions.assertThat(new BinaryTreeSolutions().areMirrors(root1, root2)).isTrue();
	}

	@Test
	public void findSum() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		final BinaryTreeNode left = new BinaryTreeNode(3);
		final BinaryTreeNode right = new BinaryTreeNode(-1);
		final BinaryTreeNode leftOf2 = new BinaryTreeNode(2);
		final BinaryTreeNode rightOf2 = new BinaryTreeNode(1);
		rightOf2.setLeft(new BinaryTreeNode(1));
		left.setLeft(leftOf2);
		left.setRight(rightOf2);
		final BinaryTreeNode leftOf3 = new BinaryTreeNode(4);
		leftOf3.setLeft(new BinaryTreeNode(1));
		leftOf3.setRight(new BinaryTreeNode(2));
		final BinaryTreeNode rightOf3 = new BinaryTreeNode(5);
		rightOf3.setRight(new BinaryTreeNode(6));
		right.setLeft(leftOf3);
		right.setRight(rightOf3);
		root.setLeft(left);
		root.setRight(right);
		final List<List<Integer>> result = new ArrayList<>();
		new BinaryTreeSolutions().findSum(5, 5, result, new ArrayList<Integer>(), root);
		System.out.println(result);
	}

	@Test
	public void buildTree() {
		final int[] inOrder = { 4, 2, 5, 1, 3 };
		final int[] preOrder = { 1, 2, 4, 5, 3 };
		final int[] postOrder = { 4, 5, 2, 3, 1 };
		final int len = inOrder.length;
		final BinaryTreeNode root = new BinaryTreeSolutions().buildTree(inOrder, preOrder, 0, len - 1);
		final BinaryTreeNode root2 = new BinaryTreeSolutions().buildTreePost(inOrder, postOrder, 0, len - 1);
		System.out.println(root);
		System.out.println(root2);
	}

	@Test
	public void lca() {
		// below method assumes that keys are present in Binary Tree. If one key
		// is present and other is absent, then it returns the present key as
		// LCA (Ideally should have returned NULL).
		Assertions.assertThat(new BinaryTreeSolutions().findLCA(this.root, 4, 6).getData()).isEqualTo(1);

		Assertions.assertThat(new BinaryTreeSolutions().findLCAInternal(this.root, 4, 8)).isEqualTo(-1);
		Assertions.assertThat(new BinaryTreeSolutions().findLCAHack(this.root, 4, 8)).isNull();
		Assertions.assertThat(new BinaryTreeSolutions().findLCAHack(this.root, 4, 6).getData()).isEqualTo(1);
	}

	@Test
	public void printAncestor() {
		new BinaryTreeSolutions().printAllAncestors(this.root, this.root.getRight().getLeft());
		new BinaryTreeSolutions().printPath(this.root);
		new BinaryTreeSolutions().printSpiral(this.root);
		new BinaryTreeSolutions().printSpiralStack(this.root);
		new BinaryTreeSolutions().sumVertical(this.root);
	}

	@Test
	public void getAllBST() {
		final ArrayList<BinaryTreeNode> trees = new BinaryTreeSolutions().generateTrees(3);
		Assertions.assertThat(trees.size()).isEqualTo(5);
		for (final BinaryTreeNode binaryTreeNode : trees) {
			System.out.println("For root node " + binaryTreeNode);
			new BinaryTreeSolutions().printPath(binaryTreeNode);
		}

	}

	@Test
	public void buildTreeWithSpecialChar() {
		final BinaryTreeNode node = new BinaryTreeSolutions().buildTreeFromPreOrder("IILLL".toCharArray(), 0);
		System.out.println(node);
		System.out.println(node.getLeft());
		System.out.println(node.getRight());
	}

	@Test
	public void inOrder() {
		final List<Integer> result = this.root.inOrderTraversal(this.root);
		Assertions.assertThat(result).containsExactly(4, 2, 5, 1, 6, 3, 7);
		this.root.inOrder(this.root);
	}

	@Test
	public void inOrderSuccessor() throws Exception {
		final BinaryTreeNode parent = null;
		int result = new BinaryTreeSolutions().inOrderSuccessor(this.root, 5, parent);
		Assertions.assertThat(result).isEqualTo(1);
		result = new BinaryTreeSolutions().inOrderSuccessor(this.root, 2, parent);
		Assertions.assertThat(result).isEqualTo(5);
		final BinaryTreeNode root2 = new BinaryTreeNode(100);
		result = new BinaryTreeSolutions().inOrderSuccessor(root2, 100, parent);
		Assertions.assertThat(result).isEqualTo(-1);
	}

	@Test
	public void reverseLevelOrder() {
		new BinaryTreeSolutions().reverseLevelOrder(this.root);
		
	}
}
