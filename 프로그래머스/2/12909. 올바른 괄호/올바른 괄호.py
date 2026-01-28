from collections import deque

def solution(s):
    answer = True
    stack=deque()
    
    for c in s:
        if c=='(':
            stack.append(c)
        else:
            if len(stack)==0:
                answer=False
                break
            else:
                pair=stack.pop()
    if len(stack)!=0:
        answer=False
    return answer