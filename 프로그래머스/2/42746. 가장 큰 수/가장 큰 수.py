def solution(numbers):
    answer = ''
    s_numbers=[]
    for i in numbers:
        s=str(i)
        s_numbers.append(s*3)
    s_numbers.sort(reverse=True)

    for i in s_numbers:
        l=len(i)//3
        a=i[0:l]
        answer+=a
    answer=str(int(answer))
    
    return answer