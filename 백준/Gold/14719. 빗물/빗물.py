h,w=map(int,input().split())
blocks=list(map(int,input().split()))

rain=0

for idx in range(1,w-1):
    right_max=max(blocks[idx+1:])
    left_max=max(blocks[:idx])
    temp=min(right_max,left_max)
    
    rain+=max(0,temp-blocks[idx])
print(rain)