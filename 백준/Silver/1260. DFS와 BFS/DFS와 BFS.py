import sys
input=sys.stdin.readline
from collections import deque

bfs_ans=[]
dfs_ans=[]

def bfs(v):
    visited=[0]*(n+1)
    visited[v]=1
    queue.append(v)
    while queue:
        cur = queue.popleft()
        bfs_ans.append(cur)

        for i in graph[cur]:
            if visited[i]==0:
                visited[i]=1
                queue.append(i)

def dfs(v):
    visited_dfs[v]=1
    dfs_ans.append(v)

    for i in graph[v]:
        if visited_dfs[i]==0:
            dfs(i)

n,m,v = map(int, input().split())
visited_dfs=[0]*(n+1)
graph = []
for _ in range(n+1):
    graph.append([])
queue=deque()
for _ in range(m):
    x,y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in graph:
    i.sort()

dfs(v)
print(*dfs_ans)
bfs(v)
print(*bfs_ans)