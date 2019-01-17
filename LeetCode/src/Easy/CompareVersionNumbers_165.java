package Easy;
/*
 * https://oj.leetcode.com/problemset/algorithms/
 */
public class CompareVersionNumbers_165 {

	public int compareVersion(String v1, String v2) {
        char[] a = v1.toCharArray();
        char[] b = v2.toCharArray();
        int i = 0,j = 0;
        int x = 0, y = 0;
        
        while(i < v1.length() || j < v2.length()){
            x = 0;y = 0;
            while(i < a.length && a[i] != '.'){
                x = x*10 + a[i] - '0';
                i++;
            }
            i++;
            while(j < b.length && b[j] != '.'){
                y = y*10 + b[j] - '0';
                j++;
            }
            j++;
            System.out.println("Comparing:"+x+","+y);
            if(x>y) return 1;
            if(y>x) return -1;
        }
        return 0;
    }
    
	public static void main(String[] args) {
		CompareVersionNumbers_165 obj = new CompareVersionNumbers_165();
		System.out.println("Result:"+obj.compareVersion("1","1.1"));
	}
}
