from collections import deque

def solution(maps):
    answer = []
    rows = len(maps)
    cols = len(maps[0])
    visited = [[False] * cols for _ in range(rows)]

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    for r in range(rows):
        for c in range(cols):
            if maps[r][c] != 'X' and not visited[r][c]:
                total_food = 0
                queue = deque([(r, c)])
                visited[r][c] = True
                
                while queue:
                    curr_r, curr_c = queue.popleft()
                    total_food += int(maps[curr_r][curr_c])
                    
                    for i in range(4):
                        nr, nc = curr_r + dr[i], curr_c + dc[i]
                        
                        if 0 <= nr < rows and 0 <= nc < cols:
                            if maps[nr][nc] != 'X' and not visited[nr][nc]:
                                visited[nr][nc] = True
                                queue.append((nr, nc))
                
                answer.append(total_food)
    
    return sorted(answer) if answer else [-1]