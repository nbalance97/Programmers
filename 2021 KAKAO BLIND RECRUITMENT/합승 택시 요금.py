def floyd(array):
    import copy
    cp_array = copy.deepcopy(array)
    n = len(cp_array)
    for i in range(1, n):
        for j in range(1, n):
            for k in range(1, n):
                if cp_array[j][i] + cp_array[i][k] < cp_array[j][k]:
                    cp_array[j][k] = cp_array[j][i] + cp_array[i][k]
    
    return cp_array
    

def solution(n, s, a, b, fares):
    INT_MAX = 2000000001
    answer = 0
    matrix = [[INT_MAX] * (n+1) for _ in range(n+1)]
    for c, d, f in fares:
        matrix[c][d] = min(matrix[c][d], f)
        matrix[d][c] = min(matrix[c][d], f)
    
    for i in range(n+1):
        matrix[i][i] = 0
        
    distance = floyd(matrix)
    
    min_distance = INT_MAX
    for i in range(1, n+1):
        min_distance = min(min_distance, distance[s][i] + distance[i][b] + distance[i][a])
    
    answer = min_distance
    return answer
