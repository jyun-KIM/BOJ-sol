from collections import deque

def timeToMin(time):
    h,m=time.split(":")
    result=60*int(h)+int(m)
    return result

def solution(plans):
    answer = []
    converted_plans = []
    for name, start, playtime in plans:
        converted_plans.append([name, timeToMin(start), int(playtime)])
    plans=sorted(converted_plans, key=lambda x:x[1])
    stack=deque()
    for i in range(len(plans) - 1):
        name, start, playtime=plans[i] #현재 진행 중인 과제의 시작/필요 시간 
        
        #i+1 시작 시간 전까지 진행
        next_start=plans[i+1][1] #다음 과제 시작 시간
        gap = next_start - start
        
        if playtime > gap:
            # 다 못 끝냄 -> 남은 시간 계산해서 스택에 추가
            stack.append([name, playtime - gap])
        else:
            # 끝냄 -> 정답에 추가하고, 남은 시간으로 스택 털기
            answer.append(name)
            remain = gap - playtime
            
            while remain > 0 and stack:
                s_name, s_playtime = stack.pop()
                if s_playtime <= remain:
                    answer.append(s_name)
                    remain -= s_playtime
                else:
                    stack.append([s_name, s_playtime - remain])
                    remain = 0
                    
    # 마지막 과제는 무조건 끝냄
    answer.append(plans[-1][0])
    
    # 스택에 남은 것들(가장 최근 멈춘 순서) 처리
    while stack:
        answer.append(stack.pop()[0])
            
    return answer