from itertools import permutations

def solution(k, dungeons):
    answer = -1

    for p in permutations(dungeons, len(dungeons)):
        cur_k=k
        count=0
        for dungeon in p:
            if cur_k>=dungeon[0]:
                cur_k-=dungeon[1]
                count+=1
        answer=max(answer, count)
    return answer