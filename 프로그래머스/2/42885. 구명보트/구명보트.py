def solution(people, limit):
    answer = 0
    people.sort()
    right=len(people)-1
    left=0
    
    while left<=right:
        if people[left]+people[right]<=limit:
            answer+=1
            left+=1
            right-=1
        else: #무거운 사람만 보냄
            answer+=1
            right-=1
        
    return answer