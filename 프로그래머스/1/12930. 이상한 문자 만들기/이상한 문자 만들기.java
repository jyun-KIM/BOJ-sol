class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //공백이면 sb.append(' ') 
            if(c==' '){
                sb.append(' ');
                idx=0;
                continue;
            }
                //idx=0 continue
            //idx 짝수 upper
            if(idx%2==0){
                sb.append(Character.toUpperCase(c));
            }
            //idx 홀수 lower
            else{
                sb.append(Character.toLowerCase(c));
            }
            //idx+=1
            idx+=1;
            
        }
        return sb.toString();
    }
}