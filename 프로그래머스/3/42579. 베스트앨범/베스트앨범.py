from collections import Counter

def solution(genres, plays):
    answer = []

    d_total={} # 장르: 총 합
    d_gp={} # 장르: 고유 번호, 횟수
    for i in range(len(genres)):
        if genres[i] not in d_total.keys():
            d_total[genres[i]]=plays[i]
            d_gp[genres[i]]=[(i, plays[i])]
        else:
            d_total[genres[i]]+=plays[i]
            d_gp[genres[i]].append((i, plays[i]))
    
    sorted_total = sorted(d_total.items(), key=lambda x:x[1], reverse=True)
    
    for genres, total in sorted_total:
        sorted_gp = sorted(d_gp[genres], key=lambda x:(-x[1],x[0]))
        
        for song in sorted_gp[:2]:
            answer.append(song[0])

    
    return answer