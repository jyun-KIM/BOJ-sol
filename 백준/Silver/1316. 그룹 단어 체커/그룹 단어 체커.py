def solution(word):
    dupli=[]
    idx=0
    for _ in range(len(word)-1):
        # print("word[idx]: ",word[idx])
        if word[idx] in dupli and word[idx]!=word[idx-1]:
            # print(dupli)
            return 0
        dupli.append(word[idx])
        idx+=1
    if word[idx] in dupli and word[idx]!=word[idx-1]:
        return 0
    return 1
n = input()
answer=0
for _ in range(int(n)):
    word=input()
    answer+=(solution(word))
print(answer)
