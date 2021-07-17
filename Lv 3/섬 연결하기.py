import heapq

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    
    return parent[a]

def union(parent, a, b):
    t1 = find(parent, a)
    t2 = find(parent, b)
    if t1 != t2:
        parent[t1] = t2
        
def solution(n, costs):
    answer = 0
    heap = []
    for src, dest, cost in costs:
        heapq.heappush(heap, [cost, src, dest])

    selected_edges = 0
    parent = [i for i in range(n)]
    
    while heap:
        cost, src, dest = heapq.heappop(heap)
        t1 = find(parent, src)
        t2 = find(parent, dest)
        if t1 != t2:
            union(parent, src, dest)
            answer += cost
            selected_edges += 1
            if selected_edges == n-1:
                break
        
    return answer
