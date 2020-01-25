package com.interviewbit.binarytree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {
	public void connect(final TreeLinkNode root) {
		final Queue<TreeLinkNode> q = new LinkedList<>();
		q.add(root);

		// null marker to represent end of current level
		q.add(null);

		// Do Level order of tree using NULL markers
		while (!q.isEmpty()) {
			final TreeLinkNode p = q.peek();
			q.remove();
			if (p != null) {

				// next element in queue represents next
				// node at current Level
				p.next = q.peek();

				// push left and right children of current
				// node
				if (p.left != null) {
					q.add(p.left);
				}
				if (p.right != null) {
					q.add(p.right);
				}
			}
			// if queue is not empty, push NULL to mark
			// nodes at this level are visited
			else if (!q.isEmpty()) {
				q.add(null);
			}
		}
	}

	void connectRecur(final TreeLinkNode p) {
		// Base case
		if (p == null) {
			return;
		}

		// Set the nextRight pointer for p's left child
		if (p.left != null) {
			p.left.next = p.right;
		}

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child
		// at its level
		if (p.right != null) {
			p.right.next = (p.next != null) ? p.next.left : null;
		}

		// Set nextRight for other nodes in pre order fashion
		this.connectRecur(p.left);
		this.connectRecur(p.right);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(final int x) {
		this.val = x;
	}
}
