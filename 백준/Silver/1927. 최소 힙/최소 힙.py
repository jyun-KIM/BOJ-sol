import sys
input=sys.stdin.readline
import heapq

n=int(input())
heap=[]

for _ in range(n):
    cur=int(input())
    if cur==0:
        if len(heap)==0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, cur)

