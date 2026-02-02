from itertools import permutations


def check_prime(n):
    if n < 2: return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    arr_num=[]
    for n in numbers:
        arr_num.append(n)
    
    result=set(list(permutations(arr_num,len(arr_num))))
    
    candidate_set=set()
    for i in range(1,len(arr_num)+1):
        perms=permutations(arr_num, i)
        for p in perms:
            p="".join(p)
            candidate_set.add(int(p))
    for i in candidate_set:
        if check_prime(i): 
            answer+=1
    
    return answer