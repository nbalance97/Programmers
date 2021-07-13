def union(parent, a, b):
    t1 = find(parent, a)
    t2 = find(parent, b)
    
    if t1 != t2:
        parent[t1] = parent[t2]

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])

    return parent[a]

def solution(n, computers):
    answer = 0
    parent = [i for i in range(n)]
    
    for i in range(n):
        for j in range(i+1, n):
            if computers[i][j] == 1:
                t1 = find(parent, i)
                t2 = find(parent, j)
                if t1 != t2:
                    union(parent, t1, t2)
    
    count = dict()
    for i in range(n):
        find(parent, i) # Tuning
    
    answer = len(set(parent))
    return answer
