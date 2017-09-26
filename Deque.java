/*
 * Jack Martin
 * CPI 220
 * 
 * DEQUE.java
 */

package deque;


import  edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Deque.java
 * This class implements a double-ended Queue or deque (pronounced "deck")
 *
 *
 * API
   public class Deque<Item> implements Iterable<Item>{
   public Deque()                   						// construct an empty deque
   public boolean isEmpty()          						// return true if the queue is empty, false otherwise
   public int size()  													// return number of items in deque
   public boolean validItem(Item item)  				// return true if item is not null; null items not allowed on deque
   public void pushHead(Item item)   						// insert the item at the head of the deque; does not push null item
   public void pushTail(Item item)  				  	// insert the item at the tail of the deque; does not push null item
   public Item popHead()           						  // delete and return the item at the head in the deque; if no item exists, return null
   public Item popTail()            				 	  // delete and return the item at the tail in the deque; if no item exists, return null
   public Item peek(int numSteps)      			 		// return the  item numSteps from the Head in the deque (0 returns Head); return null if invalid numSteps
   public Iterator												    	// iterate from Head to Toe
   }
 *
 * main() at the end of this file tests the deque ADT
 * It reads the file dequeTest.txt , which is expected to be a list of strings
 * See main for the tests of the functionality of deque
 *
 *
 */

public class Deque<Item> implements Iterable<Item>{

	private Node head;	
	private Node tail;	
	private int numItems;

	private class Node {
		Item item;
		Node headDir;	//previous
		Node tailDir;	//next
						//				<-- head
						//					tail -->
	}

	//********//
	//	DEQUE ()
	//********//
	public Deque() {
		//creating instances
		numItems = 0;
		head = new Node();
		tail = new Node();

		tail.headDir = head; //next
		tail.tailDir = null; //previous

		head.headDir = tail;
		head.tailDir = null;
	}

	//**********************//
	//public boolean isEmpty()          // return true if the queue is empty, false otherwise
	//**********************//
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}

	//*******//
	//	SIZE ()
	//*******//
	public int size() {
		return numItems;
	}

	//*****************************//
	//public boolean validItem(Item item)	// return true if item is not null; null items not allowed on deque
	//*****************************//
	public boolean validItem(Item item) {
		if(item != null)
			{
			return true;
			}
		else
			return false;
	}

	//*********************//
	//	PUSH HEAD (Item item)
	//*********************//
	public void pushHead(Item item) {	// add to the head side of que
		boolean pass;
		pass = validItem(item);

		if(pass == true)
		{
			Node newNode = new Node();
			numItems++;
			newNode.item = item;

			if( size() == 1) {	//if its the first node this is how we add
				head = newNode;
				tail = newNode;
			}else {
				head.headDir = newNode;
				newNode.tailDir = head;
				head = newNode;
			}
		}

	}//***	END OF pushHead()	***//

	//*********************//
	//	PUSH TAIL (Item item) 	
	//*********************//
	public void pushTail(Item item) {
		boolean pass;
		pass = validItem(item);

		if(pass == true) {
			Node newNode = new Node();
			numItems++;
			newNode.item = item;

			if( size() == 1) { //if its the first node this is how we add
				head = newNode;
				tail = newNode;
			}else {
				//	how we add multiple nodes after the first
				tail.tailDir = newNode;
				newNode.headDir = tail;
				tail = newNode;
			}
		}
	}//*** END OF pushTail()	***//

	//***********//
	//	POP HEAD ()
	//***********//
	public Item popHead() {
		if( isEmpty() == true) {
			//System.out.println("###");
			return null;
		}else {
			Item returnItem = head.item; //returning the deleted one.
			head = head.tailDir;
			//head.headDir = null;	//the new head has PREVIOS pointer pointing to null
			numItems--;

			return returnItem;
		}
	}//*** END OF popHead()	***//


	//***********//
	//	POP TAIL ()
	//***********//
	public Item popTail() {
		if( isEmpty() == true) {
			return null;
		}else {
			Item returnItem = tail.item;
			tail = tail.headDir;
			if(tail == null) {
				head = null;
			}else {
				tail.tailDir = null;
			}
			numItems--;

			return returnItem;
		}
	}//*** END OF popTail()	***//

	//*******************//
	//	PEAK (int numSteps)    
	//*******************//
	public Item peek(int numSteps) {
		int j = 0;
		if (numSteps > numItems)
			return null;

		if (numSteps == 0)
			return  head.item;

		Node tempNode = new Node();
		tempNode = head;
		while(j < numSteps) {
			tempNode = tempNode.tailDir;

			j++;
		}
		return tempNode.item;
	}

	public Iterator<Item> iterator() { return new Head2ToeIterator(); }

	private class Head2ToeIterator implements Iterator<Item> {
		private Node now = head;

		@Override
		public boolean hasNext() {
			//If it doenst equal null its true and there is a next node
			return now != null;
		}

		@Override
		public Item next() {
			if (now == null)
                throw new NoSuchElementException();

			Item nextItem = now.item;
			now = now.tailDir;

			return nextItem;
		}

	}

	/*
	 * main() for testing Deque
	 */
	public static void main(String[] args) {

		 Deque<String> history1 = new Deque<String>();
		 Deque<String> history2 = new Deque<String>();
		 Deque<String> history3 = new Deque<String>();
		 Deque<String> history4 = new Deque<String>();
		 Deque<String> history5 = new Deque<String>();

		 /*
		  * Check performance of constructor
		  */
		 StdOut.println("Hello Deque history1,  are you empty?  " + history1.isEmpty() + "           size=  " + history1.size());
		 StdOut.println("Hello Deque history2,  are you empty?  " + history2.isEmpty() + "           size=  " + history2.size());
		 StdOut.println("Hello Deque history3,  are you empty?  " + history3.isEmpty() + "           size=  " + history3.size());
		 StdOut.println("Hello Deque history4,  are you empty?  " + history4.isEmpty() + "           size=  " + history4.size());
		 StdOut.println("Hello Deque history5,  are you empty?  " + history5.isEmpty() + "           size=  " + history5.size());
		 StdOut.println(" ");

		 /*
		  * Read an Input file with strings
		  */

		 //Can take file name as argument
		 //StdOut.println("input file name = " + args[0]);
		 //In inputFile = new In(args[0]);

		 //Simplify grading by reading a fixed file
		 In inputFile = new In("dequeTest.txt");

		 /*
		  * TEST 1:
		  * Read,  push to Head, print from Head to Tail with foreach
		  */
		 while(!inputFile.isEmpty()) {
			 String s = inputFile.readString();
			 history1.pushHead(s);
		 }

		 StdOut.println(" ");
		 StdOut.println("TEST 1 ");
		 StdOut.println("Deque  loaded by push to Head       empty = " + history1.isEmpty() + "       size=  " + history1.size());
		 StdOut.println("Print head to tail ");
		 for(String s : history1)
			 StdOut.print(s + " ");
		 StdOut.println("  ");

		 /*
		  * 	END TEST 1:
		  */

		 /*
		  * TEST 2
		  * RE-open file
		  * Read,  pushed to Tail, print from Head to Tail with foreach
		  */
		 inputFile = new In("dequeTest.txt");

		 while(!inputFile.isEmpty()) {
			 String s = inputFile.readString();
			 history2.pushTail(s);
		 }

		 StdOut.println(" ");
		 StdOut.println("TEST 2 ");
		 StdOut.println("Deque  loaded loaded by push to Tail       empty = " + history2.isEmpty() + "       size=  " + history2.size());
		 StdOut.println("Print head to tail ");

		 for(String s : history2)
			 StdOut.print(s + " ");

		 StdOut.println("  ");
		 /*
		  * END TEST 2
		  */

		 /*
		  * TEST 3
		  * RE-open file
		  * Read,  pushed to Head, pop all from Head, print from Head to Tail with foreach
		  */
		 inputFile = new In("dequeTest.txt");

		 while(!inputFile.isEmpty()) {
			 String s = inputFile.readString();
			 history3.pushHead(s);
		 }

		 while(history3.size() > 0)  {
			 history3.popHead();
		 }
		 StdOut.println(" ");
		 StdOut.println("TEST 3");
		 StdOut.println("Deque  loaded by push from Head and pop all from Head       empty = " + history3.isEmpty() + "       size=  " + history3.size());
		 StdOut.println("Print head to tail ");
		 for(String s : history3)
			 StdOut.print(s + " ");
		 StdOut.println("  ");
		 /*
		  * END TEST 3
		  */

		 /*
		  * TEST 4
		  * RE-open file
		  * Read,  pushed to Tail, pop all from Tail, print from Head to Tail with foreach
		  */

		 inputFile = new In("dequeTest.txt");

		 while(!inputFile.isEmpty()) {
			 String s = inputFile.readString();
			 history4.pushTail(s);
		 }
		 while(history4.size() > 0)  {
			 history4.popTail();
		 }

		 StdOut.println(" ");
		 StdOut.println("TEST 4");
		 StdOut.println("Deque  loaded by push from Tail and pop all from Tail       empty = " + history4.isEmpty() + "       size=  " + history4.size());
		 StdOut.println("Print Head to Tail ");
		 for(String s : history4)
			 StdOut.print(s + " ");
		 StdOut.println("  ");
		 /*
		  * END TEST 4
		  */
		 /*
		  * TEST 5:
		  * Read,  push to Head and Tail (duplicating item), pop last item from head and tail, print from Head to Tail with foreach
		  */
		 inputFile = new In("dequeTest.txt");

		 while(!inputFile.isEmpty()) {
			 String s = inputFile.readString();
			 history5.pushHead(s);
			 history5.pushTail(s);
		 }

		 StdOut.println(" ");
		 StdOut.println("TEST 5 ");
		 StdOut.println("Deque  loaded by push to Head and Tail  (duplicate item)      empty = " + history5.isEmpty() + "       size=  " + history5.size());
		 StdOut.println("Print head to tail ");
		 for(String s : history5)
			 StdOut.print(s + " ");
		 StdOut.println("  ");

		 String poppedHead  = history5.popHead();
		 String poppedTail =     history5.popTail();
		 StdOut.println("Popped one item from Head and Tail       empty = " + history5.isEmpty() + "       size=  " + history5.size());
		 StdOut.println("Popped Tail string  " + poppedTail + "     Popped Head string " + poppedHead);

		 // Test the validItem method
		 history5.pushTail(null);
		 StdOut.println("Pushed null item  now  size=  " + history5.size());

		 /*
		  * Test Peek by printing out the last two items in history5
		  */
		 StdOut.println("   " );
		 StdOut.println("Test Peek for " );
		 for(int i=0;  i<2; i++)
			 StdOut.println("Peek    " + i +  "   " +history5.peek(i));


		 StdOut.println(" ");
		 StdOut.println("Goodbye Deque");


	}//*** END OF main()	***//


}//end of public class Deque<Item>
