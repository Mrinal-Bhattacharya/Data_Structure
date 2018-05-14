package com.java.ds.basic.linkedlist;

public class LruCache<K, V> {

	private static final int BUCKET_SIZE = 16;
	private final int cacheSize;
	int currentSize = 0;

	Entry<K, V>[] bucket = new Entry[LruCache.BUCKET_SIZE];
	Entry<K, V> head, tail;

	public LruCache(final int size) {
		this.cacheSize = size;
	}

	public void put(final K key, final V value) {
		final int index = key.hashCode() % LruCache.BUCKET_SIZE;
		Entry<K, V> entry = this.bucket[index];
		final Entry<K, V> newEntry = new Entry<>(key, value);
		if (this.currentSize == 0) {
			this.head = newEntry;
			this.tail = newEntry;
			this.bucket[index] = newEntry;
			this.currentSize++;
			return;
		}
		if (this.currentSize == this.cacheSize) {
			final int tailIndex = this.tail.key.hashCode() % LruCache.BUCKET_SIZE;
			if (this.bucket[tailIndex] == this.tail) {
				this.bucket[tailIndex] = this.tail.next;
			} else {
				Entry<K, V> prev = null;
				Entry<K, V> curr = this.bucket[tailIndex];
				while (curr != this.tail) {
					prev = curr;
					curr = curr.next;
				}
				prev.next = curr.next;
			}
			final Entry<K, V> newTail = this.tail.before;
			newTail.after = null;
			this.tail = newTail;
			this.currentSize--;
		}
		if (entry == null) {
			this.bucket[index] = newEntry;
			this.addInHead(newEntry);
			this.currentSize++;
			return;
		}
		while (entry.next != null) {
			entry = entry.next;
		}
		entry.next = newEntry;
		this.addInHead(newEntry);
		this.currentSize++;
	}

	public V get(final K key) {
		final int hash = key.hashCode() % LruCache.BUCKET_SIZE;
		Entry<K, V> entry = this.bucket[hash];
		while (!entry.key.equals(key)) {
			entry = entry.next;
		}
		if (entry == null) {
			return null;
		}
		this.remove(entry);
		this.addInHead(entry);
		return entry.value;
	}

	private void remove(final Entry<K, V> entry) {
		if (entry == this.tail) {
			final Entry<K, V> newTail = this.tail.before;
			newTail.after = null;
			this.tail = newTail;
			entry.before = null;
		} else {
			final Entry<K, V> prev = entry.before;
			final Entry<K, V> next = entry.after;
			prev.after = next;
			next.before = prev;
		}
	}

	private void addInHead(final Entry<K, V> entry) {
		entry.after = this.head;
		this.head.before = entry;
		this.head = entry;
	}

	private static class Entry<K, V> {
		public Entry(final K key, final V value) {
			this.key = key;
			this.value = value;
		}

		K key;
		V value;
		Entry<K, V> next;
		Entry<K, V> after;
		Entry<K, V> before;

		@Override
		public String toString() {
			return "Entry [key=" + this.key + ", value=" + this.value + "]";
		}

	}
}
