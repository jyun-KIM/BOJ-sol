def solution(name):
    answer = 0
    
    move=0
    for n in name:
        nex=ord(n)-ord('A')
        pre=26-(ord(n)-ord('A'))
        move+=min(nex,pre)
    n=len(name)
    
    right_only=0
    for i in range(n):
        if name[i]!='A':
            right_only =i
    left_only=0
    for i in range(1,n):
        if name[n-i]!='A':
            left_only=i
        
    min_move=min(right_only, left_only)
    for i in range(n):
        next_idx=i+1
        while next_idx<n and name[next_idx]=='A':
            next_idx+=1
            
        dist1 = 2 * i + (n - next_idx)
        dist2 = i + 2 * (n - next_idx)
        
        min_move = min(min_move, dist1, dist2)
    
    return move+min_move