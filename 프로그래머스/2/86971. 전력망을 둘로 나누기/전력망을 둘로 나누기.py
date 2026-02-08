from collections import deque

def bfs(n, start_node, forbidden_node, graph):
    visited=[False for _ in range(n+1)]
    queue=deque([start_node])
    visited[start_node]=True
    visited[forbidden_node]=True
    count=1
    
    while queue:
        cur=queue.popleft()
        for n in graph[cur]:
            if visited[n]==False:
                visited[n]=True
                queue.append(n)
                count+=1
    return count
    

def solution(n, wires):
    answer = n
    graph=[[] for _ in range(n+1)]
    # 연결 상태를 입력
    for v1,v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
    
    # 하나씩 끊으면서 확인
    for v1,v2 in wires:
        # 탐색으로 각 트리에서 몇 개의 노드가 있는지 확인
        cv1=bfs(n,v1,v2,graph)
        # 두 서브트리의 노드 차 (answer)
        temp=n-cv1
        cv2=abs(temp)
        # min answer 
        temp=cv1-cv2
        answer=min(answer, abs(temp))
    return answer