import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        answer = new StringBuilder(sorted).reverse().toString();
        return answer;
    }
}