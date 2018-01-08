package intColl;
//*********************************************************************

// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
//*********************************************************************

import java.util.*;

public class Intcoll3 {
	private boolean[] c;
	private int how_many;

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 */
	public Intcoll3() {
		c = new boolean[501];
		how_many = 0;
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 */
	public Intcoll3(int howmany) {
		c = new boolean[howmany];
		how_many = howmany;
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 */
	public void copy(Intcoll3 obj) {
		if (this != obj) {
			c = new boolean[obj.c.length];
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
		if(i<c.length && i>0 && c[i] == true)
			return true;
		else
			return false;
	}

	/**
	 * If i>0 and i is not in the collection then i is added to the collection
	 * 
	 * Input: the element to be inserted
	 */
	public void insert(int i) {
		if (i > 0) {
			if (i == c.length-1) {
				boolean[] temp = new boolean[(c.length - 1) * 2];
				for (int x = 0; x < c.length; x++) {
					temp[x] = c[x];
				}
				temp[i] = true;
				c = temp;
				how_many++;
			}
			else{
				c[i] = true;
				how_many++;
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
			c[i] = false;
			how_many--;
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
		while (j<c.length) {
			if(c[j]){
				System.out.println(j);
			}
			j++;
		}
	}

	/**
	 * Returns true if integers in the collection are exactly the same as the
	 * integers in obj
	 * 
	 * Input: the Intcoll to be compared Output: boolean true or false
	 */
	public boolean equals(Intcoll3 obj) {
		int j = 0;
		boolean result = true;
		if (this.get_howmany() == obj.get_howmany()) {
			while ((j != how_many)) {
				result = obj.belongs(j);
				if(result == true){
					if(result != this.belongs(j))
						break;
				}
				j++;
			}
		} else
			result = false;
		return result;
	}
}
