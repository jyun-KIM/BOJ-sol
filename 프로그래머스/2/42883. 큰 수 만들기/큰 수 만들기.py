from collections import deque

def solution(number, k):
    answer = ''
    stack=deque()
    for n in number:
        while stack and k>0 and stack[-1]<n:
            stack.pop()
            k-=1
        stack.append(n)

    
    answer="".join(stack)
    if len(stack)>(len(number)-k):
        answer=answer[:-k]
    
    return answer