def solution(citations):
    answer = 0
    citations.sort()
    n=len(citations) #논문 수
    print(n)
    citations.insert(0,0)
    print(citations)
    if citations[n-1]==0:
        answer=0
    else:
        for i in range(n,-1,-1):
            answer+=1
            print(citations[i-1], citations[i],answer)
            if citations[i-1]<=answer<=citations[i]:
                print(citations[i-1], citations[i],answer)
                break
    return answer