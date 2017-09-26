package robotSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.*;

public class client {
	
	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		double time;
		
		robotSort.main(args);
		
		Object deque[] = new Object[100]; 
		deque = robotSort.makeData(deque);
		
		time = timer.elapsedTime();
		
		StdOut.println("\nelapsed time: " + time + "\n");
		
		DoublingRatio.main(args);
		
	}
	
}

//need to make data -- shuffle data -- and load data into deque
//	then start timer -- and start sorting -- with a given inout
//		end timer		
//	repeat this with doubling the the input size 
//		then print out chart.
