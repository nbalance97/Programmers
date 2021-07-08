from collections import deque

def check(place, x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    queue = deque()
    queue.append([x, y, 0])
    visited = set()
    visited.add(tuple([x, y]))
    while queue:
        a, b, c = queue.popleft()
        if c == 2:
            continue
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if nx >= 0 and nx <= len(place)-1 and ny >= 0 and ny <= len(place[0])-1:
                if tuple([nx, ny]) not in visited:
                    visited.add(tuple([nx, ny]))
                    if place[nx][ny] == 'P':
                        return False
                    if place[nx][ny] == 'X':
                        continue
                    queue.append([nx, ny, c+1])
    
    return True


def solution(places):
    answer = []
    
    for place in places:
        people = []
        for i in range(len(place)):
            for j in range(len(place[0])):
                if place[i][j] == 'P':
                    people.append([i, j])
        
        flag = True
        for x, y in people:
            if not check(place, x, y):
                flag = False
                break
        
        if flag:
            answer.append(1)
        else:
            answer.append(0)
            
    
    return answer
