n = int(input())
p = list(map(int,input().split()))
time = 0 
prev=0

for _ in range(len(p)):
    x = min(p)
    time = time+(prev+x)
    p.remove(x)
    prev+=x
    
print(time)
