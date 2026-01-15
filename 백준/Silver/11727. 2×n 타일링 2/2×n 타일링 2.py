import sys
input=sys.stdin.readline

n=int(input())

if n==1:
    print(1)
elif n==2:
    print(3)
else:
    n2=1
    n1=3
    for _ in range(3,n+1):
        x=((n2%10007) + (n2%10007) + (n1%10007))%10007
        n2=n1
        n1=x
    
    print(x)
    