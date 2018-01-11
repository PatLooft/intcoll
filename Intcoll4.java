package assignment2;
//*********************************************************************

// FILE NAME    : Intcoll4.java
// DESCRIPTION  : This file contains the class Intcoll4.
//*********************************************************************

import java.util.*;

public class Intcoll4 {
	private ListNode c;
	private int how_many;

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 */
	public Intcoll4() {
		c = null;
		how_many = 0;
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 */
	public Intcoll4(int i) {
		c = null;
		how_many = 0;
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 */
	public void copy(Intcoll4 obj) {
		if (this != obj) {
			this.how_many = obj.how_many;
			if (obj.c == null) {
				c = null;
			} 
			else {
				c = new ListNode();
				c.info = obj.c.info;
				ListNode q = obj.c.link;
				ListNode p = c;

				while (q != null) {
					p.link = new ListNode();
					p = p.link;
					p.info = q.info;
					q = q.link;
				}
			}
		}

	}

	/**
	 * Checks if the element is in the array
	 * 
	 * Input: element of the set 
	 * Output: boolean true or false
	 */
	public boolean belongs(int i) {
		ListNode p = c;
		while((p != null) && (p.info != i)){
			p = p.link;
		}
		return (p != null);
	}

	/**
	 * If i>0 and i is not in the collection then i is added to the collection
	 * 
	 * Input: the element to be inserted
	 */
	public void insert(int i) {
		//code from class
		ListNode p = c;
		if (i > 0) {
			while ((p != null) && (p.info != i)) {
				p = p.link;
			}
			if (p == null) { // for the first integer to be added to each list
				how_many++;
				p = new ListNode(i, c);
				c = p;
			}

		}
	}

	/**
	 * Removes i from the collection if i is in the collection
	 * 
	 * Input: the element to be removed from the set
	 */
	public void omit(int i) {
		ListNode p = c;
		ListNode prev = null;
		if (i > 0) {
			if (this.belongs(i)) {
				while ((p != null) && (p.info != i)) {
					prev = p;
					p = p.link;
				}
				if (p != null) {
					if (prev == null) {
						c = p.link;
					} else {
						prev.link = p.link;
					}
					how_many--;
				}
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
		ListNode p = c;
		System.out.println();
		while((p != null)){
			System.out.println(p.info);
			p=p.link;
		}
	}

	/**
	 * Returns true if integers in the collection are exactly the same as the
	 * integers in obj
	 * 
	 * Input: the Intcoll to be compared Output: boolean true or false
	 */
	public boolean equals(Intcoll4 obj) {
		ListNode p = c;
		ListNode d = obj.c;
		boolean valid = true;
		
		if(how_many == obj.how_many){
			while((p != null) && valid){
				if(this.belongs(d.info)){
					p = p.link;
					d = d.link;
				}
				else
					valid = false;
			}
		}
		else{
			valid = false;
		}
		return valid;
	}
	
	//The inner class for ListNode
	private class ListNode{
		private int info;
		private ListNode link;
		
		public ListNode(){
			info = 0;
			link = null;
		}
		
		public ListNode(int i, ListNode link){
			info = i;
			this.link = link;
		}
	}
	
}
