package com.java.ds.basic.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FixedSizeArrayQueueSpec {

	@Test
	public void testEnQueue() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		Assertions.assertThat(queue.size()).isEqualTo(2);

	}

	@Test
	public void testDeQueue() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		Assertions.assertThat(queue.deQueue()).isEqualTo(10);
	}

	@Test
	public void testIsEmpty() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		Assertions.assertThat(queue.isEmpty()).isTrue();
	}

	@Test
	public void testIsFull() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		queue.enQueue(10);
		Assertions.assertThat(queue.isFull()).isFalse();
	}

	@Test
	public void testSize() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		queue.enQueue(10);
		Assertions.assertThat(queue.size()).isEqualTo(1);
	}

	@Test
	public void testToString() {
		final FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		queue.enQueue(10);
		Assertions.assertThat(queue.toString()).isEqualTo("[10]");
	}

}
