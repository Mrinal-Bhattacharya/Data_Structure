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

}
