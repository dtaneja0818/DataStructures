package Array_String;
import java.util.*;
public class E6_1a_ChkUniqueCharInString {

	public static void main(String[] args) {
		int flag=1;
		String str="";
		System.out.println("enter a string");
		Scanner in=new Scanner(System.in);
		str=in.nextLine();
		boolean arr[]=new boolean[256];
		for(int i=0;i<256;i++){//initialise arr to false
			arr[i]=false;
		}
		for(int i=0;i<str.length();i++){
			int val=str.charAt(i);//translate char to int value
			if(arr[val]){//if arr[true] it means char has already been referenced once
				System.out.println("Repetition of char: "+ str.charAt(i));
				flag=0;
				break;  
			}
			else
				arr[val]=true;        //first time put true for char                     
		}
		if(flag==1){
			System.out.println("no repetition");
		}
	}
}


