//Replace all spaces with %20

package Array_String;

import java.util.Scanner;

public class Replace_all_spaces_with_3chars_1_5 {

    public static void main(String[] args) {
        String str;
        int scount=0;
        System.out.println("enter a string");
        Scanner in=new Scanner(System.in);
        str=in.nextLine();
        char arr[]=str.toCharArray();		//Take an input from user and convert it into char array
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')scount++;		//now count the number of spaces in it
        }
        int newlen=str.length()+scount*2;		//now create a new char arr with old length + space count*2
        char newarr[]=new char[newlen];
        String newstr;
        int i=0,j=0;
        while(i<str.length()){		//now run a loop on old char arr and put the char from old to the new arr one by one
            if(arr[i]==' '){		//if space occurs replace it with %20 and the increment the counter of new arr by 3 and old by 1
            	newarr[j]='%';		
                newarr[j+1]='2';
                newarr[j+2]='0';
                j+=3;
                i++;
            }
            else					//else increment counter for both array by 1
            {
                newarr[j]=arr[i];
                i++;j++;
            }
        }
        System.out.println("New string is");
        for(i=0;i<newarr.length;i++)
        	System.out.print(newarr[i]);

    }

}