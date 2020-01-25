package com.interviewbit.binarytree.roottoleaf;

import java.util.ArrayList;
import java.util.Stack;

import com.interviewbit.binarytree.TreeNode;

public class RootToLeafPathsWithSum {
	private final ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> pathSum(final TreeNode A, final int B) {

		if (A == null) {
			return this.resultList;
		}
		final Stack<Integer> path = new Stack<>();
		this.pathSumHelper(A, B, path);
		return this.resultList;
	}

	private void pathSumHelper(final TreeNode A, final int B, final Stack<Integer> path) {
		path.push(A.val);
		if ((A.left == null) && (A.right == null)) {
			if (B == A.val) {
				this.resultList.add(new ArrayList<>(path));
			}
		}
		if (A.left != null) {
			this.pathSumHelper(A.left, B - A.val, path);
		}
		if (A.right != null) {
			this.pathSumHelper(A.right, B - A.val, path);
		}
		path.pop();

	}
}
