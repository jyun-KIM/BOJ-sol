def solution(sizes):
    answer = 0
    bw=[]
    bh=[]
    for i in sizes:
        bw.append(max(i))
        bh.append(min(i))
    answer=max(bw)*max(bh)
        
    return answer