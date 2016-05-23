package com.java.ds.basic.stack;

import java.util.EmptyStackException;

public class ArrayWithThreeStacks {
	private final Integer[] dataArray;
	private int size;
	private int topOne;
	private int topTwo;
	private int topThree;
	private int baseThree;

	public ArrayWithThreeStacks(final int size) {
		if (size < 3) {
			throw new IllegalStateException("Size < 3 is no permissible");
		}
		this.dataArray = new Integer[size];
		this.topOne = -1;
		this.topTwo = size;
		this.baseThree = size / 2;
		this.topThree = this.baseThree;
	}

	public void push(final int stackId, final int data) {
		if (stackId == 1) {
			if ((this.topOne + 1) == this.baseThree) {
				if (this.stack3IsRightShiftable()) {
					this.shiftStack3ToRight();
					this.dataArray[++this.topOne] = data;
				} else {
					throw new StackOverflowError("Stack 1 has reached max limit");
				}
			} else {
				this.dataArray[++this.topOne] = data;
			}
		} else if (stackId == 2) {
			if ((this.topTwo - 1) == this.baseThree) {
				if (this.stack3IsLeftShiftable()) {
					this.shiftStack3ToLeft();
					this.dataArray[--this.topTwo] = data;
				} else {
					throw new StackOverflowError("Stack 2 has reached max limit");
				}
			} else {
				this.dataArray[--this.topTwo] = data;
			}
		} else if (stackId == 3) {
			if ((this.topTwo - 1) == this.baseThree) {
				if (this.stack3IsLeftShiftable()) {
					this.shiftStack3ToLeft();
					this.dataArray[++this.topThree] = data;
				} else {
					throw new StackOverflowError("Stack 3 has reached max limit");
				}
			} else {
				this.dataArray[++this.topThree] = data;
			}
		}
	}

	public int pop(final int stackId) {
		if (stackId == 1) {
			if (this.topOne == -1) {
				throw new EmptyStackException();
			}
			final int toPop = this.dataArray[this.topOne];
			this.dataArray[this.topOne--] = null;
			return toPop;
		} else if (stackId == 2) {
			if (this.topTwo == this.size) {
				throw new EmptyStackException();
			}
			final int toPop = this.dataArray[this.topTwo];
			this.dataArray[this.topTwo++] = null;
			return toPop;
		} else if (stackId == 3) {
			if ((this.topThree == this.size) && (this.dataArray[this.topThree] == null)) {
				throw new EmptyStackException();
			}
			final int toPop = this.dataArray[this.topThree];
			if (this.topThree > this.baseThree) {
				this.dataArray[this.topThree--] = null;
			}
			if (this.topThree == this.baseThree) {
				this.dataArray[this.topThree] = null;
			}
			return toPop;
		}
		return -1;
	}

	public int peek(final int stackId) {
		if (stackId == 1) {
			if (this.topOne == -1) {
				throw new EmptyStackException();
			}
			return this.dataArray[this.topOne];
		} else if (stackId == 2) {
			if (this.topTwo == this.size) {
				throw new EmptyStackException();
			}
			return this.dataArray[this.topTwo];
		} else if (stackId == 3) {
			if ((this.topThree == this.size) && (this.dataArray[this.topThree] == null)) {
				throw new EmptyStackException();
			}
			return this.dataArray[this.topThree];
		}
		return -1;
	}

	public boolean isEmpty(final int stackId) {
		if (stackId == 1) {
			return this.topOne == -1;
		} else if (stackId == 2) {
			return this.topTwo == this.size;
		} else if (stackId == 3) {
			return (this.topThree == this.baseThree) && (this.dataArray[this.baseThree] == null);
		}
		return true;
	}

	private void shiftStack3ToLeft() {
		for (int i = this.baseThree - 1; i <= (this.topThree - 1); i++) {
			this.dataArray[i] = this.dataArray[i + 1];
		}
		this.dataArray[this.topThree--] = null;
		this.baseThree--;
	}

	private boolean stack3IsLeftShiftable() {
		if ((this.topOne + 1) < this.baseThree) {
			return true;
		}
		return false;
	}

	private void shiftStack3ToRight() {

		for (int i = this.topThree + 1; i >= (this.baseThree + 1); i--) {
			this.dataArray[i] = this.dataArray[i - 1];
		}
		this.dataArray[this.baseThree++] = null;
		this.topThree++;
	}

	private boolean stack3IsRightShiftable() {
		if ((this.topThree + 1) < this.topTwo) {
			return true;
		}
		return false;
	}
}
