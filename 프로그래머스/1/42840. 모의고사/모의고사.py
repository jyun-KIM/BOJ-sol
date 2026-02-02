def solution(answers):
    answer = []
    
    c1,c2,c3=0,0,0
    
    sol1=[1,2,3,4,5]
    sol2=[2,1,2,3,2,4,2,5]
    sol3=[3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        i1=i%5
        i2=i%8
        i3=i%10
        
        if answers[i]==sol1[i1]: c1+=1
        if answers[i]==sol2[i2]: c2+=1
        if answers[i]==sol3[i3]: c3+=1
    
    scores=[c1,c2,c3]
    ms=max(scores)
    result=[]
    for i in range(len(scores)):
        if ms==scores[i]:
            result.append(i)
    result.sort()
    for i in result:
        answer.append(i+1)
    
    return answer