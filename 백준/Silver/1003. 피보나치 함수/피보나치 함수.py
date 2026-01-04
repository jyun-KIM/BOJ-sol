import sys
input=sys.stdin.readline

n=int(input())
dp=[(0,0)]*41
dp[0]=(1,0)
dp[1]=(0,1)

for i in range(2,41):
    dp[i] = (dp[i-2][0]+dp[i-1][0], dp[i-2][1]+dp[i-1][1])
              
for _ in range(n):
    tc = int(input())
    print(dp[tc][0], dp[tc][1])
