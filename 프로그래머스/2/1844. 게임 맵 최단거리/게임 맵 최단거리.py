from collections import deque

def solution(maps):
    answer = 0
    n=len(maps)
    m=len(maps[0])
    
    #시작지점으로부터 거리를 나타내는 dist배열 초기화
    dist=[[0]*m for _ in range(n)]
    dist[0][0]=1
    
    #dy,dx배열 정의
    dy=[-1,1,0,0]
    dx=[0,0,-1,1]
    
    #시작지점부터 큐에 넣고 탐색 시작
    queue=deque([(0,0)])
    while queue:
        r,c=queue.popleft()

        #동서남북 한칸씩 중 벽이 아닌 부분 큐에 삽입
        for i in range(4):
            nr=r+dy[i]
            nc=c+dx[i]
            if 0<=nr<n and 0<=nc<m and maps[nr][nc]==1 and dist[nr][nc]==0:
                queue.append([nr,nc])
                #dist 업데이트
                dist[nr][nc]=dist[r][c]+1
        answer=dist[n-1][m-1]
        if answer==0:
            answer=-1
    return answer