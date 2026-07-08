class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s;i++){
            sb.append(my_string.charAt(i));
        }
        answer=sb.toString()+overwrite_string;
        // System.out.println(s+overwrite_string.length());
        if(my_string.length()>s+overwrite_string.length()){ //원래 문자열이 더 기니까 
            // System.out.println(s+overwrite_string.length());
            //뒤에 나머지 붙이기
            // System.out.println(my_string.substring(s+overwrite_string.length(),my_string.length()));
            answer+=my_string.substring(s+overwrite_string.length(),my_string.length());
        }
        return answer;
    }
}