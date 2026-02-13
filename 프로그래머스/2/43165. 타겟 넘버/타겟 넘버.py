from collections import deque    
    
def solution(numbers, target):
    answer = 0
    n=len(numbers)

    def dfs(idx, cur_sum):
        if idx==n:
            if cur_sum==target:
                return 1
            else: return 0
        res=dfs(idx+1, cur_sum+numbers[idx])
        res+=dfs(idx+1, cur_sum-numbers[idx])
        return res
    answer=dfs(0,0)
        
    return answer