package BitManipulation;
/*
 * 5.3
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 7 bits in their binary representation
 * 
 * The Brute Force Approach
 * An easy approach is simply brute force: count the number of 1 s in n, and then increment
 * (or decrement) until you find a number with the same number of Is
 */
public class NextSmallestAndNextLargestWithSameBits_3 {

	private int larger(int n) throws Exception{
		if(n == 0){
			System.out.println("Enter number greater then 0");
			return n;
		}
		int lcount = 0;
		int ncount = countBitsWithOne(n);
		while(true){
			n++;
			if(n > Integer.MAX_VALUE) throw new Exception("number reached max limit");
			lcount = countBitsWithOne(n);
			if(lcount == ncount) return n;
		}
	}
	
	private int smaller(int n) throws Exception{
		if(n == 0){
			System.out.println("Enter number greater then 0");
			return n;
		}
		int scount = 0;
		int ncount = countBitsWithOne(n);
		while(true){
			n--;
			if(n < Integer.MIN_VALUE) throw new Exception("number reached min limit");
			scount = countBitsWithOne(n);
			if(scount == ncount) return n;
		}
	}
	private int countBitsWithOne(int n){
		int count = 0, i = 1, loop = 0;
		while(loop < 32){
			if((n&i) == i) count++;
			i = i<<1; loop++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		NextSmallestAndNextLargestWithSameBits_3 obj = new NextSmallestAndNextLargestWithSameBits_3();
		try{
			System.out.println("Next larger number is:"+obj.larger(2));
			System.out.println("Next smaller number is:"+obj.smaller(2));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
