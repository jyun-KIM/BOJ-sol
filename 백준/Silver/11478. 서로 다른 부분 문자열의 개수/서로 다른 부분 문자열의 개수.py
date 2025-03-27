S = input()
part = set()

for i in range(len(S)+1):
    for j in range(i):
        x=S[j:i]
        part.add(x)
print(len(part))