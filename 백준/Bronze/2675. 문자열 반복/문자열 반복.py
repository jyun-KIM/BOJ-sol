num = int(input())

P=''
for _ in range(num):
    repeat, S = map(str, input().split())
    for s in S:
        P+=s*int(repeat)
    P+='\n'
print(P)
