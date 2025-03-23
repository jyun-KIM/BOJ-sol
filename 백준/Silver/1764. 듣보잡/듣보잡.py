N, M = map(int, input().split())
dictN = set()
result = []

for _ in range(N):
    dictN.add(input())

for _ in range(M):
    key = input()
    if key in dictN:
        result.append(key)

result.sort()
print(len(result))
for y in result:
    print(y)