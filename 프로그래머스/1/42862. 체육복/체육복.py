def solution(n, lost, reserve):
    answer = 0
    final_reserve=set(reserve)-set(lost)
    final_lost=set(lost)-set(reserve)
    final_lost=sorted(final_lost)
    answer+=(n-len(final_lost))
    
    for r in final_reserve:
        if r-1 in final_lost:
            final_lost.remove(r-1)
            answer+=1
        elif r+1 in final_lost:
            final_lost.remove(r+1)
            answer+=1
    return answer