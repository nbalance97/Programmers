from collections import deque, defaultdict
import heapq

def area_bfs(area, land, start, value, height):
    queue = deque([start])
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    area[start[0]][start[1]] = value
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx and nx < len(land) and 0 <= ny and ny < len(land[0]):
                if area[nx][ny] == int(10e9) and abs(land[cx][cy] - land[nx][ny]) <= height:
                    area[nx][ny] = value
                    queue.append([nx, ny])

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    return parent[a]

def union(parent, a, b):
    p1 = find(parent, a)
    p2 = find(parent, b)
    
    if p1 != p2:
        parent[p1] = p2


def solution(land, height):
    answer = 0
    
    # 구간별로 번호 매김
    INT_MAX = int(10e9)
    area = [[INT_MAX] * len(land[0]) for _ in range(len(land))] 
    number = 1
    for i in range(len(area)):
        for j in range(len(area[0])):
            if area[i][j] == INT_MAX:
                area_bfs(area, land, [i, j], number, height)
                number += 1
    
    # 구간 그래프화
    dx = [1, 0]
    dy = [0, 1]
    
    distance = defaultdict(lambda: int(10e9))
    for i in range(len(area)):
        for j in range(len(area[0])):
            for k in range(2):
                nx, ny = i + dx[k], j + dy[k]
                if 0 <= nx < len(area) and 0 <= ny < len(area[0]) and area[i][j] != area[nx][ny]:
                    # 작은 지역번호가 앞으로 가도록 간선정보 구성
                    # key : (작은 지역 번호, 큰 지역 번호) = 최소 이동 거리
                    src = min(area[i][j], area[nx][ny])
                    dest = max(area[i][j], area[nx][ny])
                    distance[(src, dest)] = min(distance[(src, dest)], abs(land[nx][ny] - land[i][j]))
    
    
    parent = [i for i in range(number)]
    heap = []
    
    # 간선 오름차순으로 힙에 넣어줌.
    for areas, dist in distance.items():
        heapq.heappush(heap, [dist, areas])

    # 간선의 크기가 작은 순서대로 그래프에 추가
    # 사이클 형성시 패스
    while heap:
        dist, areas = heapq.heappop(heap)
        if find(parent, areas[0]) != find(parent, areas[1]):
            union(parent, areas[0], areas[1])
            answer += dist
        
    return answer
