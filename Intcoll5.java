package intcoll5;

import java.util.LinkedList;

//*********************************************************************

//FILE NAME    : Intcoll5.java
//DESCRIPTION  : This file contains the class Intcoll5.
//*********************************************************************

import java.util.*;

public class Intcoll5 {
	private LinkedList<Integer> c = new LinkedList<Integer>();

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 * 
	 * Input: none
	 * Output: void
	 */
	public Intcoll5(){
	      c = new LinkedList<Integer>();
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 * Output: void
	 */
	public Intcoll5(int i){
	      c = new LinkedList<Integer>();
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 * Output: void
	 */
	public void copy(Intcoll5 obj) {
		if(!this.equals(obj)){
			c = new LinkedList<Integer>();
			ListIterator<Integer> I = obj.c.listIterator();
			
			while(I.hasNext()){
				Integer i = I.next();
				c.add(i);
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
		return c.contains(new Integer(i));
	}

	/**
	 * If i>0 and i is not in the collection then i is added to the collection
	 * 
	 * Input: the element to be inserted
	 * Output: void
	 */
	public void insert(int i)

	{
		Integer I = new Integer(i);
		if ((i > 0) && (!c.contains(i))){
			c.addFirst(I);
		}
	}

	/**
	 * Removes i from the collection if i is in the collection
	 * 
	 * Input: the element to be removed from the set
	 * Output: void
	 */
	public void omit(int i) {
		if(c.contains(new Integer(i))){
			c.remove(new Integer(i));
		}
	}

	/**
	 * Returns the number of integers in the collection
	 * 
	 * Output: the number of integers in the collection
	 */
	public int get_howmany() {
		return c.size();
	}

	/**
	 * Outputs the integers in the collection
	 * 
	 * Input: none
	 * Output: void
	 */
	public void print() {
		ListIterator<Integer> C = c.listIterator();
		while(C.hasNext()){
			Integer i = C.next();
			System.out.println(i.intValue());
		}
	}

	/**
	 * Returns true if integers in the collection are exactly the same as the
	 * integers in obj
	 * 
	 * Input: the Intcoll to be compared Output: boolean true or false
	 */
	public boolean equals(Intcoll5 obj) {
		boolean result = true;
		int t = this.get_howmany();
		int o = obj.get_howmany();
		
		if(t == o){
			ListIterator<Integer> O = obj.c.listIterator();
			while(O.hasNext()){
				Integer i = O.next();
				if(!this.belongs(i)){
					result = false;
					break;
				}
			}
		}
		else{
			result = false;
		}
		
		return result;
	}
}
