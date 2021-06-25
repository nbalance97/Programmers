import copy
def solution(N, road, K):
    INT_MAX = 9999999999
    matrix = [[INT_MAX] * (N+1) for _ in range(N+1)]
    for a, b, c in road:
        if matrix[a][b] > c:
            matrix[a][b] = c
            matrix[b][a] = c
    
    distance = copy.deepcopy(matrix) 
    
    for i in range(1, N+1):
        distance[i][i] = 0
    
    # floyd Algorithm
    for i in range(1, N+1):
        for j in range(1, N+1):
            for k in range(1, N+1):
                distance[j][k] = min(distance[j][k], distance[j][i] + distance[i][k])
    
    
    # 1에서 도달 가능한 개수 출력
    answer = len(list(filter(lambda x:x<=K, distance[1])))
            
    return answer
