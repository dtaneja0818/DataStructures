//https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds

package WorldCodeSprintApril;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

	public static void getStepCount(int clouds, int[] arr){
		int idx =0, stepCount = 0;
		
		while(idx < clouds-1){
			if(idx != clouds-2 && arr[idx+2] != 1){
				idx = idx+2;
				stepCount++;
			}else if(arr[idx+1] != 1){
				idx++;
				stepCount++;
			}
		}
		System.out.println(stepCount);
	}
	
    public static void main(String[] args) {
    	System.out.println("Enter number of steps");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        System.out.println("Enter clouds data");
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        getStepCount(n, c);
    }
}
