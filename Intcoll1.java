package intColl;
//*********************************************************************

// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

import java.util.*;

public class Intcoll1 {
	private int[] c;

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 */
	public Intcoll1() {
		c = new int[500 + 1];
		c[0] = 0;
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 */
	public Intcoll1(int i) {
		c = new int[i + 1];
		c[0] = 0;
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 */
	public void copy(Intcoll1 obj) {
		if (this != obj) {
			c = new int[obj.c.length];
			int j = 0;
			while (obj.c[j] != 0) {
				c[j] = obj.c[j];
				j++;
			}
			c[j] = 0;
		}
	}

	/**
	 * Checks if the element is in the array
	 * 
	 * Input: element of the set Output: boolean true or false
	 */
	public boolean belongs(int i) {
		int j = 0;
		while ((c[j] != 0) && (c[j] != i))
			j++;
		return ((i > 0) && (c[j] == i));
	}

	/**
	 * If i>0 and i is not in the collection then i is added to the collection
	 * 
	 * Input: the element to be inserted
	 */
	public void insert(int i) {
		if (i > 0) {
			int j = 0;
			while ((c[j] != 0) && (c[j] != i))
				j++;
			if (c[j] == 0) {
				if (j == c.length - 1) {
					int[] temp = new int[(c.length - 1) * 2];
					for (int x = 0; x < c.length; x++) {
						temp[x] = c[x];
					}
					temp[c.length - 1] = i;
					temp[c.length] = 0;
					c = temp;
				}
				c[j] = i;
				c[j + 1] = 0;
			}
		}
	}

	/**
	 * Removes i from the collection if i is in the collection
	 * 
	 * Input: the element to be removed from the set
	 */
	public void omit(int i) {
		if (i > 0) {
			int j = 0;
			while ((c[j] != 0) && (c[j] != i))

				j++;
			if (c[j] == i) {
				int k = j + 1;
				while (c[k] != 0)
					k++;
				c[j] = c[k - 1];
				c[k - 1] = 0;
			}
		}
	}

	/**
	 * Returns the number of integers in the collection
	 * 
	 * Output: the number of integers in the collection
	 */
	public int get_howmany() {
		int j = 0, howmany = 0;

		while (c[j] != 0) {
			howmany++;
			j++;
		}
		return howmany;
	}

	/**
	 * Outputs the integers in the collection
	 */
	public void print() {
		int j = 0;
		System.out.println();
		while (c[j] != 0) {
			System.out.println(c[j]);
			j++;
		}
	}

	/**
	 * Returns true if integers in the collection are exactly the same as the
	 * integers in obj
	 * 
	 * Input: the Intcoll to be compared Output: boolean true or false
	 */
	public boolean equals(Intcoll1 obj) {
		int j = 0;
		boolean result = true;
		while ((c[j] != 0) && result) {
			result = obj.belongs(c[j]);
			j++;
		}
		j = 0;
		while ((obj.c[j] != 0) && result) {
			result = belongs(obj.c[j]);
			j++;
		}
		return result;
	}
}
