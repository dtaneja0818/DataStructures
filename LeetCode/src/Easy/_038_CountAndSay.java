package Easy;
/*
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class _038_CountAndSay {

	public String countAndSay(int n) {
		if(n < 1) return null;
		String num = "1";
		if(n == 1) return num;
		StringBuilder sb = new StringBuilder();
		int i = 0,j = 1,count = 1;
		while(n > 1){
			int len = num.length();
			i = 0;j = 1;count = 1;
			while(j < len){
				if(num.charAt(i) == num.charAt(j)){
					count++;
					j++;
				}
				else{
					sb.append(count+""+num.charAt(i));
					i = j;
					j++;
					count = 1;
				}
			}
			sb.append(count+""+num.charAt(i));
			num = new String(sb);
			sb.delete(0,sb.length());
			n--;
		}
		return num;
	}


	public static void main(String[] args) {
		_038_CountAndSay obj = new _038_CountAndSay();
		System.out.println("result: "+obj.countAndSay(4));
	}
}
