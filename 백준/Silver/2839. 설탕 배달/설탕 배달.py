n = int(input())
total = 0

if n%5 == 0: #5로 나누어 떨어짐
    print(n//5)
else:
    while n>0:
        n-=3
        total+=1
        if n%5==0:
            total+=n//5
            print(total)
            break
        if n==1 or n==2:
            print(-1)
            break
