package com.java.ds.basic.queue;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayQueueSpec {
	DynamicArrayQueue queue;

	@Before
	public void setUp() {
		this.queue = new DynamicArrayQueue();
		this.queue.enQueue(1);
		this.queue.enQueue(2);
		this.queue.enQueue(3);
		this.queue.enQueue(4);
		this.queue.enQueue(5);
		this.queue.enQueue(6);
		this.queue.enQueue(7);
		this.queue.enQueue(8);
		this.queue.enQueue(9);
		this.queue.enQueue(10);
		this.queue.enQueue(11);
		this.queue.enQueue(12);
		this.queue.enQueue(13);
		this.queue.enQueue(14);
		this.queue.enQueue(15);
		this.queue.enQueue(16);
	}

	@Test
	public void testEnQueue() {

		this.queue.enQueue(17);
		Assertions.assertThat(this.queue.size()).isEqualTo(17);

	}

	@Test
	public void testDeQueue() {
		this.queue.enQueue(17);
		Assertions.assertThat(this.queue.deQueue()).isEqualTo(1);

	}

}
