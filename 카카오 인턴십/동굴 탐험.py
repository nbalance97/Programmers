from collections import deque

def solution(n, path, order):
    answer = True  
    visited = [False] * n
    reachable = [False] * n
    graph = [[] for _ in range(n)]
    pre = {}
    pre_rev = {}
    
    for x, y in order:
        pre[y] = x # y에 도착하기 위해 행해야 할 선행조건
        pre_rev[x] = y
    
    for x, y in path:
        graph[x].append(y)
        graph[y].append(x)
    
    queue = deque()
    if pre.get(0) is None:
        queue.append(0)
    
    while queue:
        cx = queue.popleft()
        reachable[cx] = True
        if pre.get(cx) is None: # cx에 방문하려면 선행조건이 없는 경우
            visited[cx] = True
            for i in graph[cx]:
                if not visited[i]:
                    queue.append(i)
            if pre_rev.get(cx) is not None and reachable[pre_rev[cx]]: # cx가 선행조건이라면 후행조건을 다시 큐에 넣어줌
                queue.append(pre_rev[cx])
                
        else: # cx에 방문시 선행조건이 있는 경우
            if visited[pre[cx]]: # 해당 선행조건 방문한 경우
                visited[cx] = True
                for i in graph[cx]:
                    if not visited[i]:
                        queue.append(i)
    count = 0
    for i in visited:
        if i:
            count = count + 1
    
    
    if count == n:
        answer = True
    else:
        answer = False
    
    return answer
