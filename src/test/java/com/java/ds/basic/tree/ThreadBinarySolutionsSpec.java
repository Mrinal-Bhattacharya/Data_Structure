package com.java.ds.basic.tree;

import org.junit.Test;

public class ThreadBinarySolutionsSpec {

	@Test
	public void test() {
		ThreadBinaryTree root = null;
		root = new ThreadBinarySolutions().insert(root, 20);
		root = new ThreadBinarySolutions().insert(root, 10);
		root = new ThreadBinarySolutions().insert(root, 30);
		final ThreadBinaryTree node10 = new ThreadBinarySolutions().findInBT(root, 10);
		System.out.println(node10.getRight());
	}

	@Test
	public void test2() {
		ThreadBinaryTree root = null;
		root = new ThreadBinarySolutions().insert(root, 20);
		root = new ThreadBinarySolutions().insert(root, 10);
		root = new ThreadBinarySolutions().insert(root, 30);
		new ThreadBinarySolutions().inOrderTraversal(root);
	}

}
