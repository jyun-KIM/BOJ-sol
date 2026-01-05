import sys
input=sys.stdin.readline

n=int(input())
scores = [0]*(n+1)
for i in range(1,n+1):
    scores[i] = int(input().strip())

if n == 1:
    print(scores[1])
else:
    dp = [0]*(n+1)
    dp[0]=0
    dp[1]=scores[1]
    dp[2]=scores[1]+scores[2]
    
    for i in range(3,n+1):
        dp[i] = max(scores[i]+dp[i-2], scores[i]+scores[i-1]+dp[i-3])

    print(dp[n])