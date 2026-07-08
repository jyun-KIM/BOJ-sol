class Solution {
    public int solution(String s) {
        int answer = 0;
        //zero~nine의 String[] 생성
        String[] words = {
            "zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine"
        };
        for(int i=0;i<10;i++){
            if(s.contains(words[i])){
                s = s.replace(words[i], String.valueOf(i));
            }
        }
        // System.out.println(s);
        return Integer.parseInt(s);
    }
}