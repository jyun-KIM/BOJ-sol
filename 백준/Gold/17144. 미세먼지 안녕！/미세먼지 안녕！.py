import sys
input=sys.stdin.readline

r,c,t=map(int, input().split())
room=[]
ac=[] #공기청정기 위치 저장
for i in range(r):
    row=list(map(int, input().split()))
    room.append(row)
for i in range(r):
    if room[i][0]==-1:
        ac.append(i)

        
def diffuse():
    global room
    tmp_room=[[0]*c for _ in range(r)]
    dy=[-1,1,0,0]
    dx=[0,0,-1,1]

    for i in range(r):
        for j in range(c):
            # print("j:",j)
            if room[i][j]>0: #먼지가 있다면
                count=0
                for k in range(4):
                    cy=i+dy[k]
                    cx=j+dx[k]
                    if 0<=cy<r and 0<=cx<c and room[cy][cx]!=-1:
                        count+=1 #확산되는 횟수
                        amount=room[i][j]//5
                        tmp_room[cy][cx]+=amount
                tmp_room[i][j]+=(room[i][j]-amount*count)
    room=tmp_room
    room[ac[0]][0] = -1
    room[ac[1]][0] = -1
    
def air_condition_up(x):
    global room
    global r
    global c

    #왼쪽 벽: 위에서 아래로 당기기
    for i in range(x - 1, 0, -1):
        room[i][0] = room[i-1][0]
    
    #천장 벽: 오른쪽에서 왼쪽으로 당기기
    for i in range(c - 1):
        room[0][i] = room[0][i+1]
    
    #오른쪽 벽: 아래에서 위로 당기기
    for i in range(x):
        room[i][c-1] = room[i+1][c-1]
    
    #공기청정기 줄: 왼쪽에서 오른쪽으로 당기기
    for i in range(c - 1, 1, -1):
        room[x][i] = room[x][i-1]
    
    #마지막
    room[x][1] = 0
    
def air_condition_down(x):
    global room
    #왼쪽 벽: 아래에서 위로 당기기
    # x+1행(공기청정기 바로 밑)부터 r-2행까지
    for i in range(x + 1, r - 1):
        room[i][0] = room[i+1][0]

    #바닥 벽: 오른쪽에서 왼쪽으로 당기기
    for i in range(c - 1):
        room[r-1][i] = room[r-1][i+1]

    #오른쪽 벽: 위에서 아래로 당기기
    for i in range(r - 1, x, -1):
        room[i][c-1] = room[i-1][c-1]

    #공기청정기 줄: 왼쪽에서 오른쪽으로 당기기
    for i in range(c - 1, 1, -1):
        room[x][i] = room[x][i-1]

    # 마지막
    room[x][1] = 0


for _ in range(t):
    diffuse()
    air_condition_up(ac[0])
    air_condition_down(ac[1])

answer=0
for r in room:
    answer+=sum(r)
print(answer+2)
                