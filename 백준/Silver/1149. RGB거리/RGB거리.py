import sys
input = sys.stdin.readline

n = int(input())
costs = []
for _ in range(n):
    costs.append(list(map(int, input().split())))

for i in range(1,n):
    # i번째 집 r
    costs[i][0]+=min(costs[i-1][1], costs[i-1][2])

    # i번째 집 g
    costs[i][1]+=min(costs[i-1][0], costs[i-1][2])

    # i번째 집 b
    costs[i][2]+=min(costs[i-1][0], costs[i-1][1])

print(min(costs[n-1]))