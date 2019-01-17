package Array_String;
/*
 * 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string
*/

public class ReverseStringWithoutInbuildFunc_2{

    public void reverse(String input){
        int n = input.length();
        char arr[] = input.toCharArray();
        for(int i = 0,j = n-1;i < n/2 ; i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        String result = new String(arr);
        System.out.println(result);
    }

    public static void main(String[] args){
        ReverseStringWithoutInbuildFunc_2 obj = new ReverseStringWithoutInbuildFunc_2();
        obj.reverse("abcdef");
    }
}