package General;
/*RubyQuiz#126 FizzBuzz 
 * Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
 * For numbers which are multiples of both three and five print “FizzBuzz”.
 * */

import java.util.*;

public class FizzBizz {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {                    // count from 1 to 100
		      if (((i % 5) == 0) && ((i % 3) == 0))            // A multiple of both?
		        System.out.print("FizzBuzz");    
		      else if ((i % 5) == 0) System.out.print("Buzz"); // else a multiple of 5?
		      else if ((i % 3) == 0) System.out.print("Fizz"); // else a multiple of 7?
		      else System.out.print(i);                        // else just print it
		      System.out.print(", "); 
		    }
		    System.out.println();

	}

}
