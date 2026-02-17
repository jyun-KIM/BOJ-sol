def solution(routes):
    answer = 0
    answer_list=[]
    routes.sort(key=lambda x:x[1])
    temp=routes[0][1]
    answer+=1
    for r in routes:
        s,e = r[0], r[1]
        if temp<s or e<temp:
            temp=e
            answer+=1
        
    return answer