from collections import deque

n=int(input())
A=[]
for _ in range(n):
    A.append(list(map(int, input().split())))
q=deque()
max_len = 0
min_val = float('inf')
for a in A:
    if a[0]==1:
        q.append(a[1])
        if len(q)>max_len:
            max_len=len(q)
            min_val=a[1]
        elif len(q)==max_len and a[1]<min_val:
            min_val=a[1]
    else:
        q.popleft()

print(max_len, min_val)