import sys
input=sys.stdin.readline

n,m = map(int, input().split())
po_list = [0]*(n+1)
po_dict = {}

for i in range(1,n+1):
    name = input().strip()
    po_list[i] = name
    po_dict[name] = i

for _ in range(m):
    q = input().strip()
    if q.isdigit():
        print(po_list[int(q)])
    else:
        print(po_dict[q])

