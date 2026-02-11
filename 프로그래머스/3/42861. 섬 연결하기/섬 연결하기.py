def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: x[2]) 
    
    connected = {costs[0][0]} 
    
    while len(connected) < n:
        for i in range(len(costs)):
            x, y, cost = costs[i]
            
            if x in connected and y in connected:
                continue
            
            if x in connected or y in connected:
                connected.add(x)
                connected.add(y)
                answer += cost

                break
                
    return answer