package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/merging-intervals/
 */
// An interval has start time and end time
class Interval{
	int start;
	int end;
	Interval(int s, int e){
		start = s;
		end = e;
	}
}
public class MergeOverlappingIntervals {

	// The main function that takes a set of intervals, merges overlapping intervals and prints the result
	public void mergeIntervals(Vector<Interval> intervals){
		// Test if the given set has at least one interval
		if (intervals.size() <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> s = new Stack();

		// sort the intervals based on start time
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return (i1.start - i2.start);
			}
		});
		// push the first interval to stack
		s.push(intervals.firstElement());

		// Start from the next interval and merge if necessary
		for (int i = 1 ; i < intervals.size(); i++){
			// get interval from stack top
			Interval top = s.peek();

			// if current interval is not overlapping with stack top, push it to the stack
			if (top.end < intervals.get(i).start){
				s.push(intervals.get(i));
			}
			// Otherwise update the ending time of top if ending of current interval is more
			else if (top.end < intervals.get(i).end){
				top.end = intervals.get(i).end;
				s.pop();
				s.push(top);
			}
		}
		// Print contents of stack
		System.out.println("The Merged Intervals are: ");
		while (!s.empty()){
			Interval t = s.peek();
			System.out.println("["+t.start +"," +t.end + "]" + " ");
			s.pop();
		}
		return;
	}

	public static void main(String[] args) {
		MergeOverlappingIntervals obj  = new MergeOverlappingIntervals();
		// Create a set of intervals
		Vector<Interval> v = new  Vector<Interval>();
		v.addElement(new Interval(1,3));
		v.addElement(new Interval(2,4));
		v.addElement(new Interval(5,7));
		v.addElement(new Interval(6,8));
		// Merge overlapping inervals and print result
		obj.mergeIntervals(v);
	}
}
