from collections import deque

N = int(input())
q=deque()
t=deque()

for n in range(1,N+1):
    q.append(n)

while(len(q)>1):
    t.append(q.popleft())
    q.append(q.popleft())
print(*t,*q)