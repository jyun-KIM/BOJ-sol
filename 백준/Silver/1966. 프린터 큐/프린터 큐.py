from collections import deque

TC = int(input())
for tc in range(TC):
    N,M = map(int, input().split())
    weight = list(map(int,input().split()))

    d=deque()
    for n in range(N):
        d.append([n,weight[n]])
        #(인덱스,가중치) 큐 완성

    target = d.popleft()
    n=1
    while True:
        if target[1]!=max(weight):
            d.append(target)
        elif target[1]==max(weight) and target[0]!=M:
            weight.remove(max(weight))
            n+=1
        else:
            print(n)
            break
        target = d.popleft()