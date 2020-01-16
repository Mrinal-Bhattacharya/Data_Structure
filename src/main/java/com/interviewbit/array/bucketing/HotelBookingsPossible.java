package com.interviewbit.array.bucketing;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {
	public boolean hotel(final ArrayList<Integer> arrive, final ArrayList<Integer> depart, final int K) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int i = 0, j = 0, c = 0;
		while ((i < arrive.size()) && (j < depart.size())) {
			if (arrive.get(i) < depart.get(j)) {
				c++;
				i++;
			} else {
				c--;
				j++;
			}
			if (c > K) {
				return false;
			}
		}
		return true;
	}
}
