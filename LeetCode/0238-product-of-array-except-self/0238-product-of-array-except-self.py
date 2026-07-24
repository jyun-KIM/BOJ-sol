class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #배열초기화
        n = len(nums)
        ltor = [1]*n
        rtol = [1]*n
        answer=[1]*n
        #ltor 값 넣기
        for i in range(1,n):
            ltor[i] = nums[i-1]*ltor[i-1]
        #rtol 값 넣기
        for j in range(n-2,-1,-1):
            rtol[j] = nums[j+1]*rtol[j+1]
        #두 배열 곱해서 정답 
        for k in range(n):
            answer[k]=ltor[k]*rtol[k]
        return answer