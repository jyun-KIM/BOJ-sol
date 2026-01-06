import sys
input=sys.stdin.readline

n=int(input())
graph=[[] for _ in range(n+1)]

m=int(input())

for i in range(1,m+1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited=[False]*(n+1)

def solution(cur):
    visited[cur]=True
    for x in graph[cur]:
        if visited[x]==False:
            solution(x)
solution(1)
print(sum(visited)-1)