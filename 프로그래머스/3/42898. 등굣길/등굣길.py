def solution(m, n, puddles):
    answer = 0
    path=[[0 for _ in range(m)] for _ in range(n)]
    path[0][0]=1
    puddle_set = set([(p[1]-1, p[0]-1) for p in puddles])
    for i in range(n):
        for j in range(m):
            
            if i==0 and j==0:
                continue
            
            if (i, j) in puddle_set:
                path[i][j] = 0
                continue

            up = path[i-1][j] if i > 0 else 0
            left = path[i][j-1] if j > 0 else 0
            
            path[i][j] = (up + left) % 1000000007

    answer=path[n-1][m-1]
            
    return answer