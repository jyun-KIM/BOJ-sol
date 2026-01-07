import sys
input=sys.stdin.readline

tc=int(input())

for _ in range(tc):
    fashion={}
    clothes=int(input())
    for _ in range(clothes):
        name,kind = map(str,input().split())
        if kind not in fashion:
            fashion[kind]=1
        else:
            fashion[kind]+=1
    answer=1
    for x in fashion:
        answer=answer*(fashion[x]+1)

    print(answer-1)
