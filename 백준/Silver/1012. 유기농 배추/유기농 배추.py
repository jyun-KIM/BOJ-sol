import sys
input=sys.stdin.readline
from collections import deque

def bfs(y,x):
    queue = deque()
    queue.append((y,x))
    global ans
    ans+=1
    field[y][x] = 0

    while queue:
        cy,cx = queue.popleft()
        for i in range(4):
            ny=cy+dy[i]
            nx=cx+dx[i]

            if 0<=ny<n and 0<=nx<m:
                if field[ny][nx]==1:
                    field[ny][nx] = 0
                    queue.append((ny,nx))
                

t = int(input())
dy=[1,-1,0,0]
dx=[0,0,1,-1]

for _ in range(t):
    m,n,k = map(int, input().split())
    field = [[0]*m]
    ans=0
    
    for _ in range(n-1):
        field.append([0]*m)
    
    for _ in range(k):
        x,y=map(int, input().split())
        field[y][x]=1
    
    for i in range(n):
        for j in range(m):
            if field[i][j]==1:
                bfs(i,j)
    print(ans)

