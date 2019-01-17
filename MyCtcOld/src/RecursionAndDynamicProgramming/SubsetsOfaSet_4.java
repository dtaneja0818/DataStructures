package RecursionAndDynamicProgramming;
import java.util.*;
/*
 * 9.4	Write a method to return all subsets of a set.
 */
public class SubsetsOfaSet_4 {
	
	//Here we have added every new number with the set of the previous number like for ab we have 0,a,b,ab and for c we have 0,a,b,c,ac,bc,ab,abc
	private ArrayList<ArrayList<ArrayList<Character>>> getSubsetsApproach1(ArrayList<Character> input){
		ArrayList<ArrayList<Character>> set = new ArrayList<ArrayList<Character>>();
		for (int i = 0; i < input.size(); i++) {
			ArrayList<Character> temp = new ArrayList<Character>();
			temp.add(input.get(i));
			set.add(temp);
		}
		System.out.println("input:"+set);
		int n = set.size();
		ArrayList<ArrayList<ArrayList<Character>>> result = new ArrayList<ArrayList<ArrayList<Character>>>();
		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
		ArrayList first = set.get(0);
		temp.add(new ArrayList());
		temp.add(first);
		result.add(temp);
		for(int i = 1; i < set.size(); i++){
			ArrayList next = set.get(i);
			char nextelem = (Character)next.get(0);
			result.add(i,temp);
			int limit = temp.size();
			for(int j = 0 ;j < limit;j++){
				ArrayList<Character> tempFirst = new ArrayList<Character>(temp.get(j));
				tempFirst.add(nextelem);
				temp.add(tempFirst);
			}			
		}
		return result;
	}
	
	// not working http://www.geeksforgeeks.org/power-set/
	private void getSubsetsApproach2(ArrayList<Character> input){
		/*set_size of power set of a set with set_size n is (2**n -1)*/
      	int set_size = input.size();
    	double pow_set_size = Math.pow(2, set_size);
    	int counter, j;
 
    	/*Run from counter 000..0 to 111..1*/
    	for(counter = 0; counter < pow_set_size; counter++){
      		for(j = 0; j < set_size; j++){
          		/* Check if jth bit in the counter is set if set then pront jth element from set */
          		if((counter & (1<<j)) == j)	System.out.print(input.get(j));
       		}
    	}
	}
	
	public static void main(String[] args) {
		SubsetsOfaSet_4 obj = new SubsetsOfaSet_4();
		ArrayList<Character> list = new ArrayList<Character>();
			list.add('a');
			list.add('b');
			list.add('c');
		//obj.getSubsetsApproach2(list);
		ArrayList<ArrayList<ArrayList<Character>>> result = obj.getSubsetsApproach1(list);
		System.out.println("Subsets are:"+result.get(result.size()-1));
		System.out.println("with count:"+result.get(result.size()-1).size());
		
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());*/
	}

}
