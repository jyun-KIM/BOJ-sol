import sys
input=sys.stdin.readline
  

    
k,n = map(int, input().split())
lines = []
for _ in range(k):
    lines.append(int(input()))
start=1
end=max(lines)
result=0

while start<=end:
    mid=(start+end)//2

    # print(start, end)
    total=0
    for i in lines:
        total+=(i//mid)

    if n<=total:
        result=mid
        start=mid+1
        
    else:
        end=mid-1

print(result)

