import sys
input=sys.stdin.readline
from collections import deque

n,m = map(int, input().split())
dy=[-1,1,0,0]
dx=[0,0,-1,1]
miro=[]

def bfs():
    while queue:
        cy,cx=queue.popleft()
        for i in range(4):
            ny=cy+dy[i]
            nx=cx+dx[i]
            if 0<=ny<n and 0<=nx<m and (miro[ny][nx]==1):
                miro[ny][nx]=miro[cy][cx]+1
                queue.append((ny,nx))
        

for i in range(n):
    row=list(map(int, input().strip()))
    miro.append(row)

queue=deque()

queue.append((0,0))
bfs()
print(miro[n-1][m-1])