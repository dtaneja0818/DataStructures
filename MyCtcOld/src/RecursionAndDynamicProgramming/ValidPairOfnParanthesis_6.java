package RecursionAndDynamicProgramming;
import java.util.*;
/*
 * 9.6	Implement an algorithm to print all valid (i.e., properly opened and closed) combinations ofn-pairs of parentheses.
 */
 
public class ValidPairOfnParanthesis_6 {

	private Set<String> pairs(int remaining){
		Set<String> set = new HashSet();
		if(remaining == 0) set.add("");
		else{
			Set<String> prev = pairs(remaining - 1);
			for(String s : prev){
				for(int i = 0;i < s.length();i++){
					if(s.charAt(i) == '('){
						String str = insert(s,i);
						set.add(str);
					}
				}
				if(!set.contains("()"+ s))	set.add("()"+ s);
			}
		}
		return set;
	}

	private String insert(String str, int index){
		String left = str.substring(0,index+1);
		String right = str.substring(index+1,str.length());
		return left + "()" + right;
		
	}
	
	public static void main(String[] args) {
		ValidPairOfnParanthesis_6 obj = new ValidPairOfnParanthesis_6();
		Set<String> result = obj.pairs(3);
		System.out.println(result);
	}

}
