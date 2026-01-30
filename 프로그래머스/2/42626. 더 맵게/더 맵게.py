import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while True:
        first=heapq.heappop(scoville)
        if first<K:
            if len(scoville)==0:
                answer=-1
                break
            second=heapq.heappop(scoville)
            mix=first+(second*2)
            heapq.heappush(scoville, mix)
            answer+=1
        else: break
    return answer