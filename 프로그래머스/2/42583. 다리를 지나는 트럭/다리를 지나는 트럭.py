from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    queue=deque()
    t_queue=deque(truck_weights)
    
    for _ in range(bridge_length):
        queue.append(0)
    cur_w=0
    
    while cur_w>0 or len(t_queue)!=0:
        cur=queue.popleft()
        cur_w-=cur
        if len(t_queue)!=0:
            if (cur_w+t_queue[0])<=weight and len(t_queue)!=0:
                n=t_queue.popleft()
                queue.append(n)
                cur_w+=n
            else:
                queue.append(0)
        answer+=1
        
    return answer