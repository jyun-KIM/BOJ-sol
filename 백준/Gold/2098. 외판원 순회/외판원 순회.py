import sys
input = sys.stdin.readline

INF = float('inf')

def find_path(last, visited):
    # 도시 전체 방문
    if visited == (1<<n)-1:
        if w[last][0]==0:
            return INF
        else:
            return w[last][0]
    # 이미 기록된 경로 불러오기
    if dp[last][visited]!=-1:
        return dp[last][visited]

    min_val = INF
    # 가능한 다음 도시 경로 탐색
    for next_city in range(n):
        if not (visited & (1<<next_city)) and (w[last][next_city]!=0): # next_city로 갈 수 있는 조건
            res = find_path(next_city, visited|(1<<next_city))
            if res != INF:
                min_val = min(min_val, w[last][next_city]+res)
    dp[last][visited] = min_val
    return min_val

n = int(input())
w = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1]*(1 << n) for _ in range(n)]

print(find_path(0,(1<<0)))