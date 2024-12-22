croba = ['c=', 'c-', 'z=', 'd-', 'lj', 'nj', 's=', 'dz=']
word = input()
answer = 0
i = 0

while i<len(word):
    flag=0
    for alpha in croba:
        if word[i:i+len(alpha)]==alpha:
            answer+=1
            flag=1
            i+=len(alpha)
            break
    if flag==0:
        answer+=1
        i+=1
print(answer)
