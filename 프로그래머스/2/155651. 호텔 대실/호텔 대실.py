
def solution(book_time):
    answer = 0
    bt=sorted(book_time, key=lambda x:x[0])
    time=[0]*1450
    for t in bt:
        shour,smin=t[0].split(":")
        s=60*int(shour)+int(smin)
        time[s]+=1
        ehour,emin=t[1].split(":")
        e=60*int(ehour)+int(emin)+10
        time[e]-=1
    temp=0
    for i in time:
        temp+=i
        answer=max(answer,temp)
    return answer