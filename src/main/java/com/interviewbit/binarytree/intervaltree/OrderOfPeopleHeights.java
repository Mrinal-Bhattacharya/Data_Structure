package com.interviewbit.binarytree.intervaltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OrderOfPeopleHeights {
	public ArrayList<Integer> order(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		final int n = A.size();
		final Person[] persons = new Person[n];
		for (int i = 0; i < n; i++) {
			persons[i] = new Person(A.get(i), B.get(i));
		}
		Arrays.sort(persons, new Person());
		final Person[] temp = new Person[n];
		for (final Person p : persons) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (count == p.infront) {
					while ((temp[i] != null) && (i < (n - 1))) {
						i++;
					}
					temp[i] = p;
					break;
				}
				if (temp[i] == null) {
					count++;
				}
			}
		}
		final ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(temp[i].height);
		}
		return result;
	}
}

class Person implements Comparator<Person> {
	int height;
	int infront;

	public Person() {
	}

	public Person(final int height, final int infront) {
		this.height = height;
		this.infront = infront;
	}

	@Override
	public int compare(final Person p1, final Person p2) {
		return p1.height - p2.height;
	}
}