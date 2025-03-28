from collections import deque

N=int(input())
d=deque()

for n in range(1,N+1):
    d.append(n)

while(len(d)>1):
    d.popleft()
    d.append(d.popleft())

print(*d)