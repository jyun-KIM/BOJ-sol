from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    queue=deque()
    remains=[]
    # 각 기능이 배포까지 남은 날짜 계산
    for i in range(len(progresses)):
        temp=math.ceil((100-progresses[i])/speeds[i])
        remains.append(temp)
    
    count=1
    x=remains[0]
    print(remains)
    
    for i in range(1,len(progresses)):
        if remains[i]<=x:
            count+=1
        else:
            answer.append(count)
            x=remains[sum(answer)]
            count=1
    answer.append(count)
        
    return answer