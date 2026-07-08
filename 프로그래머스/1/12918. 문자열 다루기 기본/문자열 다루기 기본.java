class Solution {
    public boolean solution(String s) {
        // boolean answer = true;
        int size = s.length();
        if(size!=4 && size!=6) return false;
        //s의 char값을 하나씩 반복문으로 확인
        for(int i=0;i<size;i++){
            char c = s.charAt(i);
            // System.out.println(c);
            if(c-'0'>9 || c-'0'<0) {
                return false;
            }
        }
            //c-'0'이 그 숫자와 다르면 flase
        return true;
    }
}