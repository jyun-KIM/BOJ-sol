S = input()
result = [0] * 26

for s in S:
    result[ord(s)-97]+=1
print(' '.join(map(str, result)))