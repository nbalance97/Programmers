import heapq

def solution(n, edge):
    answer = 0
    INT_MAX = 99999999999
    heap = []
    distance = [INT_MAX] * (n+1)
    graph = [[] for _ in range(n+1)]
    
    for s, e in edge:
        graph[s].append(e)
        graph[e].append(s)
    
    distance[1] = 0
    heapq.heappush(heap, 1) # vertex, 
    while heap:
        p = heapq.heappop(heap)
        for nx in graph[p]:
            if distance[nx] > distance[p] + 1:
                distance[nx] = distance[p] + 1
                heapq.heappush(heap, nx)
    
    distance[0] = 0
    mdistance = max(distance)
    answer = distance.count(mdistance)
    
    return answer

###################################### deque 활용 

from collections import deque

def solution(n, edge):
    answer = 0
    INT_MAX = 99999999999
    queue = deque()
    distance = [INT_MAX] * (n+1)
    graph = [[] for _ in range(n+1)]
    
    for s, e in edge:
        graph[s].append(e)
        graph[e].append(s)
    
    distance[1] = 0
    queue.append(1)
    while queue:
        p = queue.popleft()
        for nx in graph[p]:
            if distance[nx] > distance[p] + 1:
                distance[nx] = distance[p] + 1
                queue.append(nx)
    
    distance[0] = 0
    mdistance = max(distance)
    answer = distance.count(mdistance)
    
    return answer
