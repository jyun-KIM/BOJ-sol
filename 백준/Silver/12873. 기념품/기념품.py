from collections import deque

N=int(input())
d=deque()
for n in range(1,N+1):
    d.append(n)
t=1
while len(d)>1:
    d.rotate(-t**3+ 1)
    x=d.popleft()
    t+=1
print(*d)