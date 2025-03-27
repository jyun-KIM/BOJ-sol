from collections import deque

N, K = map(int, input().split())
q=deque()
for n in range(1,N+1):
    q.append(n)
    
print("<",end="")
result=[]
while len(q)>0:
    q.rotate(-K)
    result.append(str(q.pop()))

print(', '.join(result), end=">")