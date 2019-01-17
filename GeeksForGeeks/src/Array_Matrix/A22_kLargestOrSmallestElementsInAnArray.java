package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * http://www.crazyforcode.com/kth-largest-smallest-element-array/
 */
public class A22_kLargestOrSmallestElementsInAnArray {

	public void findKthLargest(int[] nums, int k) {
		int[] result = new int[k];
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	    
	    // iterator prints the queue in random order not in the order the elem are stored in queue
	    Iterator<Integer> through = q.iterator() ;
	    while(through.hasNext()) {
            System.out.print(through.next() + " ") ;
        }
	    //return q.peek();
	}
	public static void main(String[] args) {
		A22_kLargestOrSmallestElementsInAnArray obj = new A22_kLargestOrSmallestElementsInAnArray();
		int[] arr = {1, 23, 12, 9, 30, 2, 50} ;
		obj.findKthLargest(arr, 1);
	}

}
