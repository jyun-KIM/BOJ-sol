def solution(array, commands):
    answer = []
    for i in commands:
        s,e,n=i[0]-1, i[1], i[2]-1
        temp=array[s:e]
        temp.sort()
        answer.append(temp[n])
    return answer