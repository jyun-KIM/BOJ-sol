def solution(N, number):
    buckets=[set() for _ in range(8)]
    for i in range(8):
        buckets[i].add(int(str(N)*(i+1)))
        for j in range(i):
            for b1 in buckets[j]:
                for b2 in buckets[i-j-1]:
                    buckets[i].add(b1+b2)
                    buckets[i].add(b1-b2)
                    buckets[i].add(b1*b2)
                    if b2!=0:
                        buckets[i].add(b1//b2)
        if number in buckets[i]:
            return i+1
    return -1
            