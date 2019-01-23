package Easy;
import java.util.HashMap;

/*
 * https://oj.leetcode.com/problems/roman-to-integer/
 */
public class E_013_RomanToInteger {

	public int romanToInt(String s) {
        if(s == null) return -1;
       	HashMap<Character, Integer> ht=new HashMap<Character, Integer>();
        ht.put('I',1);
        ht.put('V',5);
        ht.put('X',10);
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D', 500);
        ht.put('M',1000);
        
        int n=s.length();
        int sum=ht.get(s.charAt(n-1));
        for(int i=n-2; i>=0; i--){
            
            if (ht.get(s.charAt(i+1))>ht.get(s.charAt(i))){
                sum=sum-ht.get(s.charAt(i));
            }
            else if (ht.get(s.charAt(i+1))<=ht.get(s.charAt(i))){
                sum=sum+ht.get(s.charAt(i));
            }
        }
        return sum;
    }
    
    public String IntToRoman(int num) {
        if(num < 0) return null;
        
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
        String[] digits = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb=new StringBuffer();
        int i=0;
        
        while(num > 0){
        	int times = num/nums[i];
        	num = num - nums[i]*times;
        	for(;times > 0;times--){
        		sb.append(digits[i]);
        	}
        	i++;
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		E_013_RomanToInteger obj = new E_013_RomanToInteger();
		System.out.println(obj.romanToInt("XC"));
	}
}
