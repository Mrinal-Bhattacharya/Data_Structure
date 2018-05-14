package com.java.ds.basic.tree;

public class SegmentTree {

	int[] tree;
	int n;

	public void buildTree(final int[] nums) {
		this.n = nums.length;
		final int treeLength = (this.n * 2);
		this.tree = new int[treeLength];
		for (int i = this.n, j = 0; i < treeLength; i++, j++) {
			this.tree[i] = nums[j];
		}
		for (int i = this.n - 1; i > 0; --i) {
			final int leftChild = (i * 2);
			final int rightChild = (i * 2) + 1;
			this.tree[i] = this.tree[leftChild] + this.tree[rightChild];
		}
	}

	void update(int pos, final int val) {
		pos += this.n;
		this.tree[pos] = val;
		while (pos > 0) {
			// parent is updated after child is updated
			pos = pos / 2;
			this.tree[pos] = this.tree[pos * 2] + this.tree[(pos * 2) + 1];
		}
	}

	public int sumRange(int l, int r) {
		// get leaf with value 'l'
		l += this.n;
		// get leaf with value 'r'
		r += this.n;
		int sum = 0;
		while (l <= r) {
			if ((l % 2) == 1) {
				sum += this.tree[l];
				l++;
			}
			if ((r % 2) == 0) {
				sum += this.tree[r];
				r--;
			}
			l /= 2;
			r /= 2;
		}
		return sum;
	}

	public static void main(final String[] args) {
		final int nums[] = { 1, 3, 5, 7, 9, 11 };
		final SegmentTree segmentTree = new SegmentTree();
		segmentTree.buildTree(nums);
		for (final int i : segmentTree.tree) {
			System.out.println(i);
		}
		System.out.println(">>>>>>>>>>> " + segmentTree.sumRange(1, 3));
		segmentTree.update(1, 10);
		for (final int i : segmentTree.tree) {
			System.out.println(i);
		}
		System.out.println(">>>>>>>>>>>>>>>> " + segmentTree.sumRange(1, 3));
		SegmentTree.constructTree();
	}

	static int[] st;

	static void constructTree() {
		final int nums[] = { 1, 3, 5, 7, 9, 11 };
		final int x = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));

		// Maximum size of segment tree
		final int max_size = (2 * (int) Math.pow(2, x)) - 1;

		SegmentTree.st = new int[max_size]; // Memory allocation
		SegmentTree.constructSTUtil(nums, 0, nums.length - 1, 0);
	}

	static int constructSTUtil(final int arr[], final int start, final int end, final int curr) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (start == end) {
			SegmentTree.st[curr] = arr[start];
			return arr[start];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		final int mid = SegmentTree.getMid(start, end);
		SegmentTree.st[curr] = SegmentTree.constructSTUtil(arr, start, mid, (curr * 2) + 1)
				+ SegmentTree.constructSTUtil(arr, mid + 1, end, (curr * 2) + 2);
		return SegmentTree.st[curr];
	}

	private static int getMid(final int start, final int end) {
		return start + ((end - start) / 2);
	}
}
