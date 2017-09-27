/*
 * Jack Martin
 * homework 2
 * robotSort.java
 * 
 * THIS IS OUR PROGRAM THAT CREATES A DEQUE OF A GIVEN SIZE 
 * AND RUNS IT THROUGH ROBOT SORT
 * 
 * ROBOTSORT -- 	YOU CAN SWAP THE TOP TWO SHEETS ON THE DEQUE 
 * 				OR YOU CAN SHIFT THE HEAD OF THE DEQUE TO TO BOTTOM
 * 				1 > 2 -- SWAP
 * 				1 < 2 -- SHIFT
 * 				
 * 				SPEACIAL CASE IS THE WRAP CASE HAPPEN WHEN YOU ARE
 * 				COMPARING '0' TO 'N-1' 
 * 				THEN JUST DO THE OPPISITE OF THE NORMAL. 
 */

package robotSort;

import edu.princeton.cs.algs4.Knuth;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class robotSort {
	
	public static void printDeque(Deque<Object> deque) {	//obviosaly just print the deque
		int x;
		
		for(int j = 0; j < deque.size(); j++) {
			x = (int)deque.peek(j);
			StdOut.print(x + " ");
		}
		StdOut.println();
	}
	
	private static void shift(Deque<Object> deque) { // Move item from Head to Tail
		Object temp;
		int x;
		temp = deque.peek(0);
		
		deque.popHead();
		
		deque.pushTail(temp);

	}
	
	private static void exch(Deque<Object> deque) { //Exchange order of sheets at Head
		Object[] temp = {0,0};
		int x;
		temp[0] = deque.peek(0);
		temp[1] = deque.peek(1);
		
		deque.popHead();
		deque.popHead();
		
		deque.pushHead(temp[0]);
		deque.pushHead(temp[1]);
	
	}
	
	private static boolean isSorted(Deque<Object> deque) { //Is the deque sorted?
		int size = (int)deque.size();
		int i = 0;
		boolean pass = false;
		
		while(i < size-1) {
			if((int)deque.peek(i) < (int)deque.peek(i+1))
				pass = true;
			else
				return false;
			
			i++;
		}
		
		return pass; 
	}
	
	public static void sort(Deque<Object> deque) { // Sort the deque so Head is smallest item
		int loop = 0;
		
		while(loop < 1000000000) {
			
			int one;
			int two;
			one = (int) deque.peek(0);
			two = (int) deque.peek(1);
			
			if(one == 0 && two == (deque.size() - 1)) {
				exch(deque);
				shift(deque);
			}else {
				if(one > two) {
					exch(deque);
				}else if(one < two) { 
					shift(deque);
				}
			}
			
			if(isSorted(deque) == true) {
				StdOut.println("\n********************************");
				StdOut.println("SORTED");
				printDeque(deque);
				StdOut.println("********************************");
				break;
			}
			
			loop++;
		}
		
	}
	
	public static Object[] makeData(Object[] a, int sheets) {
		int size = sheets;
		
		for(int i = 0; i < size-1; i++) {
			a[i] = i;
		}
		
		Knuth.shuffle(a);
				
		size = size * 2;
		return a;
	}
	
	public static void main(String[] args, int sheet) {
		Object sdata[] = new Object[2000]; //for testing
		
		
		makeData(sdata, sheet);		//for shuffling and making data
		
		
		Deque<Object> myque = new Deque<Object>();
		
		//load data to deque
		for(int i = 0; i < sdata.length; i++) {
			myque.pushHead(sdata[i]);
		}
		
		//print out the myque from haed to tail.
		StdOut.println("\nmy deque: ");
		StdOut.println("size: " + myque.size());
		printDeque(myque);
//		
		sort(myque);
		
	}

}
