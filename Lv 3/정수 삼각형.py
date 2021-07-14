import copy

def solution(triangle):
    answer = 0
    dp = copy.deepcopy(triangle)
    for i in range(len(triangle)-1):
        for j in range(len(triangle[i])):
            dp[i+1][j] = max(dp[i+1][j], dp[i][j] + triangle[i+1][j])
            dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1])
    
    answer = max(dp[len(triangle)-1])
    
    return answer
