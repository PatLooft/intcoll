package intColl;
//*********************************************************************

// FILE NAME    : Intcoll2.java
// DESCRIPTION  : This file contains the class Intcoll2.
//*********************************************************************

import java.util.*;

public class Intcoll2 {
	private int[] c;
	private int how_many;

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 */
	public Intcoll2() {
		c = new int[500];
		c[0] = 0;
		how_many = 0;
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 */
	public Intcoll2(int howmany) {
		c = new int[howmany];
		c[0] = 0;
		how_many = howmany;
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 */
	public void copy(Intcoll2 obj) {
		if (this != obj) {
			c = new int[obj.c.length];
			int j = 0;
			while (j < c.length) {
				c[j] = obj.c[j];
				j++;
			}
		}
	}

	/**
	 * Checks if the element is in the array
	 * 
	 * Input: element of the set Output: boolean true or false
	 */
	public boolean belongs(int i) {
		int j = 0;
		while ((j != how_many) && (c[j] != i))
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
			while ((j != how_many) && (c[j] != i))
				j++;
			if (j == how_many) {
				int[] temp = new int[(c.length - 1) * 2];
				for (int x = 0; x < c.length; x++) {
					temp[x] = c[x];
				}
				temp[c.length - 1] = i;
				temp[c.length] = 0;
				c = temp;
				how_many++;
			}
			c[j] = i;

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
			while ((j < how_many) && (c[j] != i))
				j++;
			if (c[j] == i) {
				int k = how_many;
				c[j] = c[k - 1];
				c[k - 1] = 0;
				how_many--;
			}
		}
	}

	/**
	 * Returns the number of integers in the collection
	 * 
	 * Output: the number of integers in the collection
	 */
	public int get_howmany() {
		return how_many;
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
	public boolean equals(Intcoll2 obj) {
		int j = 0;
		boolean result = true;
		if (this.get_howmany() == obj.get_howmany()) {
			while ((j != how_many) && result) {
				result = obj.belongs(c[j]);
				j++;
			}
			j = 0;
			while ((j != how_many) && result) {
				result = belongs(obj.c[j]);
				j++;
			}
		} else
			result = false;
		return result;
	}
}
