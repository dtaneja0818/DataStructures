/*Take 2 string from user and chk is length is same after that concatenate str1 with itself
 * and then chk if str2 is present in this new string
 * */
package Array_String;
import java.util.*;
public class E6_9_OneStringRotationOfOther {

	public static void main(String[] args) {
		System.out.println("enter a string");
		Scanner in=new Scanner(System.in);
		String str1=in.nextLine();
		System.out.println("enter a string to be checked for rotation");
		String str2=in.nextLine();
		if(str1.length()!=str2.length()){
			System.out.println("enter strings of equal lengths");
			System.exit(0);
		}
		String str=str1+str1;
		boolean b=isSubstring(str,str2);
		if(b)System.out.println("str2 is rotation of str1");
		else System.out.println("str2 is not a rotation of str1");
	}
	public static Boolean isSubstring(String str,String str2){
		char arr1[]=str.toCharArray();
		char arr2[]=str2.toCharArray();
		int len1=arr1.length;
		int len2=arr2.length;
		int i=0,j=0,k=0;
		while(i<len1){
			while(j<len2){
				if(arr1[i]!=arr2[j])	//if elem are not equal incr counter for first string and
					break;				// move counter of second string to zero
				else
					i++;j++;		//if equal move counters for both strings
			}
			if(j==len2)
				return true;		//if str2 reaches last then it is a substring
			else 
			i++;j=0;
		}
		return false;
	}
}