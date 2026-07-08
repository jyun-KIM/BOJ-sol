class Solution {
    public String solution(String s) {
        String answer = "";
        int size = s.length();
        // System.out.println(size/2);
        if(size%2!=0) return String.valueOf(s.charAt(size/2));
        int idx = size/2 -1;
        System.out.println(idx);
        return s.substring(idx,idx+2);
    }
}