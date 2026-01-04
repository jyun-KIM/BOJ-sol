import sys
input=sys.stdin.readline

n,m = map(int, input().split())
pw_dict = {}
for _ in range(n):
    add, pw = map(str, input().split())
    pw_dict[add] = pw

for _ in range(m):
    q=input().strip()
    print(pw_dict[q])