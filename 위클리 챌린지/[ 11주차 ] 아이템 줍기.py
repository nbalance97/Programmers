import sys
from collections import defaultdict, deque

sys.setrecursionlimit(10**5)

def get_cross_point(lineA, lineB):
    p1_x, p1_y, p2_x, p2_y = lineA
    p3_x, p3_y, p4_x, p4_y = lineB
    
    # 평행인 경우
    if (p1_x == p2_x and p3_x == p4_x) or (p1_y == p2_y and p3_y == p4_y):
        return ()
    
    if p1_x == p2_x: 
        # 세로 직선인 경우
        if (p3_x < p1_x and p1_x < p4_x and p1_y < p3_y and p3_y < p2_y):
            return (p1_x, p3_y)
    else: 
        # 가로 직선인 경우
        if (p3_y < p1_y and p1_y < p4_y and p1_x < p3_x and p3_x < p2_x):
            return (p3_x, p1_y)
    
    return ()

def division(currentline, addline, deleteline, new_line):
    for exist_line in currentline:
        point = get_cross_point(new_line, exist_line)
        if point:
            deleteline.append(exist_line)
            x, y = point
            division(currentline, addline, deleteline, (new_line[0], new_line[1], x, y))
            division(currentline, addline, deleteline, (x, y, new_line[2], new_line[3]))
            division(currentline, addline, deleteline, (exist_line[0], exist_line[1], x, y))
            division(currentline, addline, deleteline, (x, y, exist_line[2], exist_line[3]))
            return

    addline.append(new_line)
        
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    line = set()
    
    for x1, y1, x2, y2 in rectangle:
        make_lines = [(min(x1, x2), y1, max(x1, x2), y1), (x2, min(y1, y2), x2, max(y1, y2)), 
                      (min(x1, x2), y2, max(x1, x2), y2), (x1, min(y1, y2), x1, max(y1, y2))]
        for new_line in make_lines:
            delete_line = []
            add_line = []
            
            division(line, add_line, delete_line, new_line)
                    
            for delete in delete_line:
                line.remove(delete)
            
            for add in add_line:
                line.add(add)

    delete_candidate = []
    # 사각형 내부에 직선이 포함되는지 확인
    for x1, y1, x2, y2 in line:
        for r_x1, r_y1, r_x2, r_y2 in rectangle:
            if x1 == x2:
                # 세로
                if r_x1 < x1 and x1 < r_x2 and r_y1 <= y1 and r_y2 >= y2:
                    delete_candidate.append((x1, y1, x2, y2))
                    break
            else:
                # 가로
                if r_y1 < y1 and y1 < r_y2 and r_x1 <= x1 and r_x2 >= x2:
                    delete_candidate.append((x1, y1, x2, y2))
                    break
    
    for candidate in delete_candidate:
        line.remove(candidate)
    
    graph = defaultdict(lambda:[])
    queue = deque()
    visited = set()
    for x1, y1, x2, y2 in line:
        if x1 <= characterX and characterX <= x2 and y1 <= characterY and characterY <= y2:
            queue.append([x1, y1, abs(x1-characterX) + abs(y1-characterY)])
            queue.append([x2, y2, abs(x2-characterX) + abs(y2-characterY)])
            visited.add((x1, y1))
            visited.add((x2, y2))
            
        graph[(x1, y1)].append((x2, y2))
        graph[(x2, y2)].append((x1, y1))
    
    # 이동 파트
    answer = int(10e9)
    while queue:
        x, y, dist = queue.popleft()
        for n_x, n_y in graph[(x, y)]:
            if min(x, n_x) <= itemX and itemX <= max(x, n_x) and \
               min(y, n_y) <= itemY and itemY <= max(y, n_y):
                answer = min(answer, dist + abs(itemX - x) + abs(itemY - y))
                continue
                
            if (n_x, n_y) not in visited:
                queue.append([n_x, n_y, dist + abs(n_x - x) + abs(n_y - y)])
                visited.add((n_x, n_y))
                        
    return answer
