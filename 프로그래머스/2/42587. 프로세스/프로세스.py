from collections import deque

def solution(priorities, location):
    answer = 0
    queue=deque()
    for i in range(len(priorities)):
        queue.append((i,priorities[i]))
    while True:
        cur=queue.popleft()
        m=0
        for i in queue:
            m=max(m,i[1])
        
        if cur[1]<m:
            queue.append(cur)
        else: 
            answer+=1
            if location==cur[0]:
                break
        
    return answer