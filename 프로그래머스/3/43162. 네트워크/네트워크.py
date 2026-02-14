def solution(n, computers):
    answer = 0
    visited=[False for _ in range(n)]
    
    def dfs(c):
        visited[c]=True
        for j in range(n):
            if computers[c][j]==1 and visited[j]==False:
                dfs(j)
        
    #for n만큼 돌면서 네트워크 개수 세기
    for i in range(n):
        if visited[i]==False:
            answer+=1
            #방문하지 않은 컴퓨터와 연결된 컴퓨터 확인
            cur=computers[i]
            for c in range(n): #연결된 컴퓨터 내에서 dfs 
                if cur[c]==1:
                    dfs(c)
    return answer