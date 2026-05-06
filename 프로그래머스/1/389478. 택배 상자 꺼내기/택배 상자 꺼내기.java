class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        //row: (num-1)/w
        //col: 짝수 row -> (num-1)%w
        //col: 홀수 row -> w-1-((num-1)%w)
        
        int row = (num-1)/w;
        int col=0;
        //row가 홀/짝에 따라 col 구하기
        if(row%2==0){
            col = (num-1)%w;
        }else {
            col = w-1-((num-1)%w);
        }
        
        int curn=num; //현재 보고 있는 상자 번호
        //curn이 n보다 작을 때까지 반복문
        while(curn<=n){
            answer+=1;
            //row+1을 하면서 해당 col의 상자 번호를 구하고 answer+1
            row+=1;
            if(row%2==0){
                curn=(row*w)+(col+1);
            }else{
                curn=(row*w)+(w-col);
            }
            System.out.printf("curn: %d, answer: %d\n", curn, answer);
            
        }
        
        return answer;
    }
}