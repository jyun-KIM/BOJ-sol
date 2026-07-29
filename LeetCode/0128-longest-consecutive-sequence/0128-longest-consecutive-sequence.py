class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        answer=0
        if len(nums_set)==1: return 1
        #set을 돌면서
        for num in nums_set:
            #num-1 in set 확인
            if (num-1) not in nums_set:
                temp_ans=1
                if answer==0: answer=1
                temp_num=num
                #없으면
                #while true
                while (temp_num+1) in nums_set:
                    #num++가 set에 있을때까지 돌면서 answer++
                    temp_ans+=1
                    temp_num+=1
                    answer=max(answer, temp_ans)
        return answer
        

