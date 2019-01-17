package Array_String;

import java.util.Scanner;

public class Remove_duplicate_char_in_String_1_3 {

	public static void main(String[] args) {
		String str;
		int count=0;
        System.out.println("enter a string");
        Scanner in=new Scanner(System.in);
        str=in.nextLine();
        int len=str.length();
        if(len<2) {System.out.println(str);System.exit(0);}
        char arr[]=str.toCharArray();
        //System.out.println(arr[0]);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]==arr[j]){
                	count++;
                    for(int k=j;k<len;k++){
                    	if(k+1==len){
                    		arr[k]='\0';
                    	}
                    	else{
                    		arr[k]=arr[k+1];
                       	}
                    }
                    len--;j--;
                    }
            }
        }
        System.out.println("String after removing repeated char : ");
        for(int i=0;i<arr.length-count;i++)
        	System.out.print(arr[i]);
        
    }

}
