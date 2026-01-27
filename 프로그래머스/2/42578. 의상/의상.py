def solution(clothes):
    answer = 0
    d_clothes={}
    for i in clothes:
        name, kind=map(str,i)
        if kind in d_clothes:
            d_clothes[kind]+=1
        else:
            d_clothes[kind]=1
            
    print(d_clothes)
    temp=1
    for v in d_clothes.values():
        temp*=(v+1)
    temp-=1
    answer+=temp
    return answer