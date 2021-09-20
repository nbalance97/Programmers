def movement(x, y, arrow):
    if arrow == 7:
        x += 1
        y -= 1
    if arrow == 6:
        y -= 1
    if arrow == 5:
        x -= 1
        y -= 1
    if arrow == 4:
        x -= 1
    if arrow == 3:
        x -= 1
        y += 1
    if arrow == 2:
        y += 1
    if arrow == 1:
        x += 1
        y += 1
    if arrow == 0:
        x += 1
    return x, y

def cross_check(edge, x, y, arrow):
    if arrow == 1:
        if (x, y+1, x+1, y) in edge or (x+1, y, x, y+1) in edge:
            return True
    elif arrow == 5:
        if (x, y-1, x-1, y) in edge or (x-1, y, x, y-1) in edge:
            return True
    elif arrow == 7:
        if (x, y-1, x+1, y) in edge or (x+1, y, x, y-1) in edge:
            return True
    elif arrow == 3:
        if (x-1, y, x, y+1) in edge or (x, y+1, x-1, y) in edge:
            return True
    
    return False


def solution(arrows):
    answer = 0
    visited = set()
    edge = set()
    x, y = 0, 0
    visited.add((x, y))
    for arrow in arrows:
        currentX, currentY = x, y
        x, y = movement(x, y, arrow)
        
        # 교차하는 대각선 여부 확인
        if arrow in [1, 3, 5, 7] and cross_check(edge, currentX, currentY, arrow):
            if (x, y, currentX, currentY) not in edge: 
                answer += 1
                
        if (x, y) in visited:
            # 반대로 돌아오는 간선 있는지 체크
            if (x, y, currentX, currentY) not in edge: 
                answer += 1
        else:
            visited.add((x, y))
            
        # 현재 간선정보 저장
        edge.add((currentX, currentY, x, y))
        edge.add((x, y, currentX, currentY))
    return answer
