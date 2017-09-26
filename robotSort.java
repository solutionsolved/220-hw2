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
//		String change = " ";
		
		while(loop < 1000000000) {
			
			int one;
			int two;
			one = (int) deque.peek(0);
			two = (int) deque.peek(1);
			
			if(one == 0 && two == (deque.size() - 1)) {
				exch(deque);
				shift(deque);
//				StdOut.println("\nWRAPED\n");
			}else {
				if(one > two) {
					exch(deque);
//					change = "exchange";
				}else if(one < two) { 
					shift(deque);
//					change = "shift";
				}
			}
			
			if(isSorted(deque) == true) {
				StdOut.println("\n********************************");
				StdOut.println("SORTED");
				printDeque(deque);
				StdOut.println("********************************");
				break;
			}
			
			//PRINT dque for testing purposes to see how it is moving
//			StdOut.print(change + ": ");
//			printDeque(deque);
			
			loop++;
		}
		
//		StdOut.println("\n********************************");
//		StdOut.println("After while loop");
//		printDeque(deque);
//		StdOut.println("********************************\n");
		
		
		
		
	}
	
	public static Object[] makeData(Object[] a) {
		int size = 0;
		size = (int)(Math.random() * 100 + 1);
		
		
//		StdOut.println("Fill Array");
		
		for(int i = 0; i < size-1; i++) {
			a[i] = i;
		}
		
//		StdOut.println("Filled Array");
//		StdOut.print("\t");
//		for(int i = 0; i < size-1; i++) {
//			StdOut.print(a[i] + " ");
//		}
		
		Knuth.shuffle(a);
		
//		StdOut.println("\nafter shuffle");
//	
//		for(int i = 0; i < 4; i++) {
//			System.out.print(a[i] + " ");
//		}
		
		return a;
	}
	
	public static void main(String[] args) {
		Object sdata[] = new Object[100]; //for testing
		
		
		makeData(sdata);		//for shuffling and making data
		
//		Object[] myData = make();  //going to return a Object of random size and random numbers
//		
//		for(int i = 0; i < 4; i++) {
//			StdOut.print(myData[i] + " ");
//		}
		
		
		Deque<Object> myque = new Deque<Object>();
		
//		StdOut.println("load to Deque: ");
		
		//load data to deque
		for(int i = 0; i < sdata.length; i++) {
			myque.pushHead(sdata[i]);
		}
		
		//print out the myque from haed to tail.
		StdOut.println("my deque: ");
		StdOut.println("size: " + myque.size());
		printDeque(myque);
//		StdOut.println();
		
		sort(myque);
	}

}