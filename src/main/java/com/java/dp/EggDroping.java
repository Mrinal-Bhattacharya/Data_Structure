package com.java.dp;

public class EggDroping {

	// if I have 1 egg then i will have to goto all the floors from bottom, because
	// we can't take a risk to break the egg.
	// Suppose we have 7 floor and 2 egg then What i will do I will drop from middle
	// and rest I will count so ans will be 4 but this logic will fail in 100
	// floors. so we need to distribute the floors for example 14 floor I will drop
	// if it break then I will cover rest below from 1 to 13 floors. if it is not
	// then I will pick floor 27 if it is break then I will start dropping egg from
	// 14 floor to 27.
	int egg_drop(final int eggs, final int floors) {
		// Base case
		if ((floors == 0) || (floors == 1) || (eggs == 1)) {
			return floors;
		}

		// Keep track of the MINIMUM number of drops needed
		int min_drops = Integer.MAX_VALUE;

		// Consider each drop from first to current floor
		for (int i = 1; i <= floors; i++) {
			// If the egg breaks on floor x, we only need to test floors up to the
			// x-1th floor. We also have one less egg since the egg broke.
			final int egg_break = this.egg_drop(eggs - 1, i - 1);

			// If the egg did not break on floor x, we only need to test floors
			// starting from the floor-xth floor onwards. The number of eggs
			// does not change since the egg did not break.
			final int egg_not_break = this.egg_drop(eggs, floors - i);

			// Find the number of drops necessary in the WORST CASE scenario.
			// Don't forget to add one to include the current drop.
			final int drops = Math.max(egg_break, egg_not_break) + 1;

			// Update memo[floor][egg] if we found a smaller number of needed
			// egg drops
			if (drops < min_drops) {
				min_drops = drops;
			}
		}

		return min_drops;
	}

	/*
	 * Function to get minimum number of trials needed in worst case with n eggs and
	 * k floors
	 */
	static int eggDropDp(final int egg, final int floor) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number of
		 * trials needed for i eggs and j floors.
		 */
		final int eggFloor[][] = new int[egg + 1][floor + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and 0 trials for 0 floors
		for (i = 1; i <= egg; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}

		// We always need j trials for one egg and j floors.
		for (j = 1; j <= floor; j++) {
			eggFloor[1][j] = j;
		}

		// Fill rest of the entries in table using optimal substructure
		// property
		for (i = 2; i <= egg; i++) {
			for (j = 2; j <= floor; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j]) {
						eggFloor[i][j] = res;
					}
				}
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[egg][floor];

	}

	/* Driver program to test to pront printDups */
	public static void main(final String args[]) {
		final int n = 2, k = 28;
		/*
		 * System.out.println("Minimum number of trials in worst case with " + n +
		 * "  eggs and " + k + " floors is " + new EggDroping().egg_drop(n, k));
		 */
		System.out.println(EggDroping.eggDropDp(n, k));
	}
}
