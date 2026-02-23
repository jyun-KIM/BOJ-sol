from collections import deque

def solution(begin, target, words):
    answer = 0
    n=len(begin)
    if target not in words:
        return 0
    queue=deque([(begin, 0)])
    visited=set()
    
    while queue:
        char,diff=queue.popleft()
        if char==target:
            return diff
        for w in words:
            if w not in visited:
                cur_diff=0
                for i in range(n):
                    if char[i]!=w[i]:
                        cur_diff+=1
                if cur_diff==1:
                    queue.append([w,diff+1])
                    visited.add(w)
    
    return answer