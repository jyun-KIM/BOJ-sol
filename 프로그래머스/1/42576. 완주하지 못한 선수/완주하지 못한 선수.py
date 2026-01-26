def solution(participant, completion):
    pa_dict={}
    for i in participant:
        if i in pa_dict:
            pa_dict[i]+=1
        else:
            pa_dict[i]=1
    for i in completion:
        pa_dict[i]-=1
    answer = [k for k,v in pa_dict.items() if v!=0]
    
    return ''.join(answer)