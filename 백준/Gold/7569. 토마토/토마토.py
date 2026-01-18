import sys
input=sys.stdin.readline
from collections import deque

m,n,h = map(int, input().split())

dz=[1,-1,0,0,0,0]
dy=[0,0,1,-1,0,0]
dx=[0,0,0,0,1,-1]
queue=deque()

graph=[]
for i in range(h):
    box=[]
    for j in range(n):
        x=list(map(int, input().split()))
        box.append(x)
    graph.append(box)

for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k]==1:
                queue.append((i,j,k))


def bfs():
    while queue:
        z,y,x = queue.popleft()

        for i in range(6):
            nz, ny, nx = z+dz[i], y+dy[i], x+dx[i]

            if 0<=nz<h and 0<=ny<n and 0<=nx<m:
                if graph[nz][ny][nx]==0:
                    graph[nz][ny][nx]=graph[z][y][x]+1
                    queue.append((nz,ny,nx))

bfs()

ans=0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k]==0:
                print(-1)
                exit(0)
            ans=max(ans,graph[i][j][k])
print(ans-1)
            

