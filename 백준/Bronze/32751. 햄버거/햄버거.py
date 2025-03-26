N = int(input())
a,b,c,d = map(int, input().split())
ham = { "a": a, "b": b, "c":c, "d":d }
S = input()
length = len(S)
flag = True

if (S[0] != 'a') or (S[length-1] != 'a'):
    print("No")
    flag = False
else:
    prev = "a"
    for i in range(1,length):
        if(S[i]==prev):
            print("No")
            flag = False
            break
        ham[S[i]] -= 1
        if (ham[S[i]])<0:
            print("No")
            flag = False
            break
        prev = S[i]
if flag == True:
    print("Yes")