class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # dict 선언
        groups = {}
        # nums를 돌면서 dict에 개수 추가
        for n in nums:
            groups[n] = groups.get(n, 0)+1
        # value 값 기준으로 정렬
        sorted_groups = sorted(
            groups.items(),
            key=lambda x: x[1],
            reverse=True
        )
        # k개만큼 출력 
        answer=[]
        for i in range(k):
            answer.append(sorted_groups[i][0])
        return answer
        