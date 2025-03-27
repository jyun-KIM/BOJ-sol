N = int(input())
D = {}

for _ in range(N):
    english, Minionese = map(str, input().split(" = "))
    D[english] = Minionese

T = int(input())
for _ in range(T):
    result = ""
    K = int(input())
    sentence = list(map(str, input().split()))
    for i in range(K):
        result=result + D[sentence[i]] + " "
    print(result)
        
        