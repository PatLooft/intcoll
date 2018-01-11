package intcoll6;
//*********************************************************************

// FILE NAME    : Intcoll6.java
// DESCRIPTION  : This file contains the class Intcoll6.
//*********************************************************************

import java.util.*;

public class Intcoll6 {
	private int howmany;
	private btNode c;

	/**
	 * The default constructor that constructs a list of positive integers with
	 * no repeats
	 * 
	 * Input: none
	 * Output: void
	 */
	public Intcoll6() {
		c = null;
		howmany = 0;
	}

	/**
	 * The alternate constructor that constructs a list of positive integers
	 * with no repeats
	 * 
	 * Input: the size of the set
	 * Output: void
	 */
	public Intcoll6(int i) {
		c = null;
		howmany = 0;
	}
	
	/**
	 * Creates a copy of a binary tree with t as the root node
	 * 
	 * Input: the root node of a binary tree
	 * Output: a copy of the binary tree
	 */
	private static btNode copytree(btNode t) {
		btNode root = null;
		if (t != null){
			root = new btNode();
			root.info = t.info;
			root.left = copytree(t.left);
			root.right = copytree(t.right);
		}
		return root;
	}

	/**
	 * Creates a copy of obj to a intcoll object
	 * 
	 * Input: the Intcoll to be copied
	 * Output: void
	 */
	public void copy(Intcoll6 obj){
		if (this != obj) {
			howmany = obj.howmany;
			c = copytree(obj.c);
		}
	}

	/**
	 * Checks if the element is in the array
	 * 
	 * Input: element of the set 
	 * Output: boolean true or false
	 */
	public boolean belongs(int i){
		btNode p = c;
		while ((p != null) && (p.info != i)){
			if (p.info > i)
				p = p.left;
			else
				p = p.right;
		}
		return (p != null);
	}

	/**
	 * If i>0 and i is not in the collection then i is added to the collection
	 * 
	 * Input: the element to be inserted
	 * Output: void
	 */
	public void insert(int i) {
		// code from class
		if (i > 0){
			btNode pred = null, p = c;

			while ((p != null) && (p.info != i)) {
				pred = p;
				if (p.info > i)
					p = p.left;
				else
					p = p.right;
			}
			
			if (p == null){
				howmany++;
				p = new btNode(i, null, null);
				if (pred != null) {
					if (pred.info > i)
						pred.left = p;
					else
						pred.right = p;
				} 
				else
					c = p;
			}
		}
	}

	/**
	 * Removes i from the collection if i is in the collection
	 * 
	 * Input: the element to be removed from the set
	 * Output: void
	 */
	public void omit(int i) {
		btNode p = c;//item to be omitted
		btNode pred = null;//the node before p

		while ((p != null) && (p.info != i)) {// search for item to be omitted
			pred = p;
			if (p.info > i)
				p = p.left;
			else
				p = p.right;
		}

		if (p != null) {// code to omit i
			// THIS DESTROYS THE ENTIRE SUBTREE FIX
			if (p.left == null && p.right == null && pred != null) {// last node in a branch
				if(pred.left == p)
					pred.left = null;
				if(pred.right == p)
					pred.right = null;
			} 
			else if (pred == null && p.right == null && p.left == null) {// single node tree
				c = null;
			} else if (p.left == null && p.right != null) {// null subtree on left
				if (p == c) {
					c = p.right;
				} else {
					pred.right = p.right;
				}
			} else if (p.left != null && p.right == null) {// null subtree on
															// right
				if (p == c) {
					c = p.left;
				} else {
					pred.left = p.left;
				}
			} else {// subtree on both left and right //this works god bless
				btNode temp = p.left; // variable for largest node in left
										// subtree
				btNode tempPred = p;
				while (temp.right != null) {// loop to get largest node in left
											// subtree
					tempPred = temp;
					temp = temp.right;
				}
				if (pred != null && p == pred.right) {// if the variable is the
														// right subnode of pred
					if (tempPred.right == temp) {// if temp is right subnode of
													// tempPred,this shouldnt
													// happen because temp is
													// largest variable in left
													// tree
						tempPred.right = null;// deletes temps original location
					}
					if (tempPred.left == temp) {
						tempPred.left = null;
					}
					temp.right = p.right;// sets temp to p's location
					temp.left = p.left;// sets temp to p's location
					pred.right = temp;// sets temp to p's location
					p = temp;
				} // this works

				else if (pred != null && p == pred.left) {// if the variable is
															// the left subnode
															// of pred
					if (tempPred.right == temp) {// if temp is right subnode of
													// tempPred,this shouldnt
													// happen because temp is
													// largest variable in left
													// tree
						tempPred.right = null;// deletes temps original location
					}
					if (tempPred.left == temp) {
						tempPred.left = null;
					}
					temp.right = p.right;// sets temp to p's location
					temp.left = p.left;// sets temp to p's location
					pred.left = temp;// sets temp to p's location
					p = temp;
				} // this works

				else if (pred == null) {// used for root node

					if (tempPred.right == temp) {
						tempPred.right = null;
					} else if (tempPred.left == temp) {
						tempPred.left = null;
					}
					temp.right = p.right;
					temp.left = p.left;

					c = temp;
				}
			}
		}
		howmany--;
	}

	/**
	 * Returns the number of integers in the collection
	 * 
	 * Output: the number of integers in the collection
	 */
	public int get_howmany() {
		return howmany;
	}

	/**
	 * Outputs the integers in the collection
	 * 
	 * Input: none
	 * Output: all integers in the tree
	 */
	public void print() {
		printtree(c);
	}
	
	
	/**
	 * Prints a binary tree with root t
	 * 
	 * Input: the root of the tree to be printed
	 * Output: a string of the integers in the tree
	 */
	private static void printtree(btNode t) {
		if (t != null) {
			printtree(t.left);
			System.out.println(t.info);
			printtree(t.right);
		}
	}
	
	/**
	 * Takes in the root of a tree and sorts tree into an array starting at index i
	 * 
	 * INPUT: the root of a binary tree, the array to put the values of the tree in, the starting index of the array
	 * OUTPUT: the number of leafnodes in the tree
	 */
	private static int toarray(btNode t, int[] a, int i) {
		int num_nodes = 0;
		if (t != null) {
			num_nodes = toarray(t.left, a, i);
			a[num_nodes + i] = t.info;
			num_nodes = num_nodes + 1 + toarray(t.right, a, num_nodes + i + 1);
		}
		return num_nodes;
	}

	/**
	 * Returns true if integers in the collection are exactly the same as the
	 * integers in obj
	 * 
	 * Input: the Intcoll to be compared 
	 * Output: boolean true or false
	 */
	public boolean equals(Intcoll6 obj){
		int j = 0, i =0;
		boolean result = (howmany == obj.howmany);
		int[] a = new int[howmany], b = new int[howmany];
		if (result) {
			j = toarray(this.c, a, 0);
			j = toarray(obj.c, b, 0);
			while(result && i<howmany){
				if(a[i] == b[i]){
					i++;
				}
				else{
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	// The inner class for btNode
	private static class btNode
	{
		private int info;
		private btNode left, right;
		
		public btNode(){
			info = 0;
			left = right = null;
		}

		public btNode(int i, btNode lt, btNode rt){
			info = i;
			left = lt;
			right = rt;
		}
	}
	
	
	
}
