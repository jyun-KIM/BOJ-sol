class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        //num_list 하나씩 확인
        for(int n:num_list){
            if(n<0) return answer;
            answer++;
        }
            //인덱스 따로 계산해두기
            //음수면 바로 리턴
        return -1;
    }
}