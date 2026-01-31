import heapq

# 소요시간 짧 > 작업 요청 시간 > 번호 작
def solution(jobs):
    answer = 0
    heap=[]
    jobs.sort()
    now=0
    i=0
    count=0
    while count < len(jobs):
        while i<len(jobs) and jobs[i][0]<=now:
            heapq.heappush(heap, [jobs[i][1],jobs[i][0],i])
            i+=1
        if heap:
            task = heapq.heappop(heap)
            now+=task[0]
            answer+=(now-task[1])
            count+=1
        else:
            now=jobs[i][0]

        
    
#     for i in range(len(jobs)):
#         s,l,n=jobs[i][0],jobs[i][1],i
#         print(s,l,n)
#         heapq.heappush(heap,[l,s,n])
#     disk=[]
#     queue=deque()
#     time=0
#     while heap:
#         time+=1
#         task=heapq.heappop(heap) # 다음으로 시작해야할 작업
#         if time>=first[1] and len(queue)==0:
#             for _ in range(first[2]):
#                 time+=1
#                 if 
        
        
    
    return answer//(len(jobs))