package Array_String;

import java.util.Scanner;

public class E6_1b_ChkUniqueCharInString {

	public static void main(String[] args) {
		int flag=1;
		String str="";
		System.out.println("enter a string");
		Scanner in=new Scanner(System.in);
		str=in.nextLine();
		outerloop:
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)){
					System.out.println("Repetition of char: "+ str.charAt(i));
					flag=0;break outerloop;
				}
			}
		}
		if(flag==1){
			System.out.println("no repetition");
		}

	}

}
