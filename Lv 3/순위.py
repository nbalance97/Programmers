def solution(n, results):
    answer = 0
    
    INT_MAX = int(10e9)
    win_matrix = [[INT_MAX] * (n+1) for _ in range(n+1)]
    lose_matrix = [[INT_MAX] * (n+1) for _ in range(n+1)]
    
    for i in range(n+1):
        win_matrix[i][i] = 0
        lose_matrix[i][i] = 0
    
    for src, dest in results:
        win_matrix[src][dest] = 1
        lose_matrix[dest][src] = 1
    
    for i in range(1, n+1):
        for j in range(1, n+1):
            for k in range(1, n+1):
                win_matrix[j][k] = min(win_matrix[j][k], win_matrix[j][i] + win_matrix[i][k])
                lose_matrix[j][k] = min(lose_matrix[j][k], lose_matrix[j][i] +
                                       lose_matrix[i][k])
    
    for i in range(1, n+1):
        count = len([k for k in win_matrix[i] if k != INT_MAX]) + len(
            [k for k in lose_matrix[i] if k != INT_MAX])
        if count == n+1:
            answer += 1
        
    
    
    return answer
