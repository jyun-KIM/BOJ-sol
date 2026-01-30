from collections import deque

def solution(prices):
    n=len(prices)
    answer=[0 for _ in range(n)]
    stack=deque()
    for i in range(0,n-1):
        for j in range(i+1,n):
            if prices[i]<=prices[j]:
                stack.append(j)
            else:
                answer[i]=1
                break
        answer[i]+=len(stack)
        stack.clear()
    return answer