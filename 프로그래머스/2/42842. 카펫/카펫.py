def solution(brown, yellow):
    answer = []
    w,h=0,0
    while True:
        w+=1
        h=(brown+yellow)/w
        if w**2>=brown+yellow and h.is_integer():
            h=int(h)
            if (w-2)*(h-2)==yellow:
                answer.append(w)
                answer.append(h)
                break
    return answer