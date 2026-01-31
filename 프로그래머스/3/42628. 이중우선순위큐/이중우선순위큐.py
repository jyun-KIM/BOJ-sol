import heapq

def solution(operations):
    answer = []
    heap=[]
    for i in operations:
        o,n=map(str, i.split())
        if o=='I':
            heapq.heappush(heap,int(n))
        if o=='D' and len(heap)!=0:
            if n=='1':
                max_val=max(heap)
                heap.remove(max_val)
                heapq.heapify(heap)

            else: # 최솟값 삭제
                heapq.heappop(heap)
    if len(heap)==0:
        answer.append(0)
        answer.append(0)
    else:
        answer.append(max(heap))
        answer.append(min(heap))
    
    return answer