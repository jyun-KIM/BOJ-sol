from itertools import product
def solution(word):
    answer = 0
    dictionary=[]
    alpha=['A','E','I','O','U']
    
    for i in range(1,6):
        for p in product(alpha, repeat=i):
            dictionary.append("".join(p))
    dictionary.sort()
    while True:
        if dictionary[answer]==word:
            break
        else:
            answer+=1
    return answer+1