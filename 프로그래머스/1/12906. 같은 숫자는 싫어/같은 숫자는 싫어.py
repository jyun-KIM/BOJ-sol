from collections import deque

def solution(arr):
    answer = []
    stack=deque()
    stack.append(arr[0])
    for i in arr:
        x=stack.pop()
        if i!=x:
            answer.append(x)
        stack.append(i)
    l=len(arr)
    answer.append(arr[l-1])
    return answer