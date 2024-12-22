croba = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()
answer = 0
i = 0

while i < len(word):
    found = False
    for croba_alpha in croba:
        if word[i:i+len(croba_alpha)] == croba_alpha:
            answer += 1
            i += len(croba_alpha)
            found = True
            break
    if not found:
        answer += 1
        i += 1

print(answer)
