def solution(sequence, k):
    answer = []
    n = len(sequence)
    
    left = 0
    right = 0
    current_sum = sequence[0]
    min_len = n + 1  
    
    while left <= right < n:
        if current_sum == k:
            # 합이 k인 구간을 찾았을 때
            length = right - left + 1
            if length < min_len:
                min_len = length
                answer = [left, right]
            
            # 다른 구간도 찾기 위해 left를 한 칸 이동
            current_sum -= sequence[left]
            left += 1
            
        elif current_sum < k:
            # 합이 부족하면 범위를 오른쪽으로 확장
            right += 1
            if right < n:
                current_sum += sequence[right]
            
        else: # current_sum > k
            # 합이 넘치면 왼쪽에서 범위를 축소
            current_sum -= sequence[left]
            left += 1
            
    return answer