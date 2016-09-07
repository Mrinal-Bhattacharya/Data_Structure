package com.java.ds.basic.tree;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeSolutionsSpec {

	BinaryTreeNode root = null;

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

}
