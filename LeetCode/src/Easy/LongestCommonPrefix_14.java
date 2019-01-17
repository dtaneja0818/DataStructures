package Easy;
import java.util.*;

public class LongestCommonPrefix_14 {

	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        int[] lengthArr = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            lengthArr[i] = strs[i].length();
        }
        Arrays.sort(lengthArr);
        int shortest = lengthArr[0];

        int commonLength = 0;
        
        for (int i = 0; i < shortest; i ++) {
            ArrayList<String> list = new ArrayList<String>();
            for (int j = 0; j < strs.length; j++) {
               // ArrayList.add(String.valueOf(strs[j].charAt(i)));
            }
            if (!isAllSameValue(list)) {
                commonLength = i;
                break;
            }
            commonLength = i + 1;
        }
        return strs[0].substring(0, commonLength);
    }

    public boolean isAllSameValue(ArrayList<String> strs){
        String tmp = strs.get(0);

        for (String s : strs) {
            if (!s.equals(tmp))
                return false;
        }
        return true;
    }
	public static void main(String[] args) {

	}
}
