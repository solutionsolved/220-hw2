/*
 * Jack Martin
 * homework 2
 * robotSortAnylis.java
 * 
 * WE CALL THE PROGRAM ROBOTSORT.JAVA TO CREATE A DEQUE OF NUMBER TO RUN TEST
 * THE TEST CONSIST OF THE DOUBLING HYPOTHESIS USING THE STOPWATCH.CLASS
 * 
 * NOT SURE I HAVE THE TABLE RIGHT.
 */

package robotSort;

import java.text.DecimalFormat;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.*;

public class robotSortAnylis {
	
	public static void dataPrint(double time,int num) {
		DecimalFormat form = new DecimalFormat("#.000");
		StdOut.println(num + "	|	" + time + "		|	" + (2*time/time) + "	|	" + form.format(Math.log(2*time/time)));
	}
	
	public static void main(String[] args) {
		double time = 0;
		double time1 = 0;
		double time2 = 0;
		double time3 = 0;
		double time4 = 0;
		int sheets = 5;
		Object[] deque = new Object[1000000]; 
		Deque<Object> myque = new Deque<Object>();
		
		
		Stopwatch timer = new Stopwatch();
		robotSort.main(args, 51);
		time = timer.elapsedTime();
		
		Stopwatch timer1 = new Stopwatch();
		robotSort.main(args, 101);
		time1 = timer1.elapsedTime();
		
		Stopwatch timer2 = new Stopwatch();
		robotSort.main(args, 201);
		time2 = timer2.elapsedTime();
		
		Stopwatch timer3 = new Stopwatch();
		robotSort.main(args, 401);
		time3 = timer3.elapsedTime();
		
		Stopwatch timer4 = new Stopwatch();
		robotSort.main(args,801);
		time4 = timer4.elapsedTime();
		
		StdOut.println("\ndoubling ratio table");
		StdOut.println("N	|	time		|	ratio	|	lg(ratio)");
		dataPrint(time, 4);
		dataPrint(time1, 8);
		dataPrint(time2, 16);
		dataPrint(time3, 32);
		dataPrint(time4, 64);
		
		StdOut.println("\nhere is our table along with each shufled and sorted deque that we created and timed");
		StdOut.println("the table gives us the number of numbers in each deque along with the time it took");
		StdOut.println("it seems to average out at 0.693 as our log(ratio)");
		
		
		
		
		
	}
	
}

//need to make data -- shuffle data -- and load data into deque
//	then start timer -- and start sorting -- with a given inout
//		end timer		
//	repeat this with doubling the the input size 
//		then print out chart.
