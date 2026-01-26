from collections import Counter

def solution(nums):
    answer = 0
    counter = Counter(nums)
    n=len(nums)//2
    if len(counter)>=n:
        answer=n
    else:
        answer=len(counter)
    return answer