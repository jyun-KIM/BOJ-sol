import sys
input=sys.stdin.readline

def dfs(r,c,depth,current_sum):
    global ans
    if current_sum+(4-depth)*max_val<=ans:
        return 
    if depth==4:
        ans=max(ans, current_sum)
        return
    for i in [[-1,0],[1,0],[0,-1],[0,1]]:
        dr=r+i[0]
        dc=c+i[1]
        if 0<=dr<n and 0<=dc<m and visited[dr][dc]==False:
            if depth==2:
                visited[dr][dc]=True
                dfs(r,c,depth+1,current_sum+board[dr][dc]) #현재(2번째 칸)에서 다시 호출
                visited[dr][dc]=False
            
            visited[dr][dc]=True
            dfs(dr, dc, depth + 1, current_sum + board[dr][dc])
            visited[dr][dc]=False

n,m=map(int, input().split())
board=[]
visited=[[False]*m for _ in range(n)]

for i in range(n):
    row=list(map(int, input().split()))
    board.append(row)
max_val=max(map(max, board))
ans=0
for i in range(n):
    for j in range(m):
        visited[i][j]=True
        dfs(i,j,1,board[i][j])
        visited[i][j]=False
print(ans)