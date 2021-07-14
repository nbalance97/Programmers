from collections import deque

def solution(m, n, puddles):
    answer = 0
    INT_MAX = int(10e9)
    dp = [[0] * m for _ in range(n)]
            
    for a,b in puddles:
        dp[b-1][a-1] = INT_MAX
    # initiate
    for i in range(m):
        if dp[0][i] == INT_MAX:
            break
        dp[0][i] = 1
        
    for i in range(n):
        if dp[i][0] == INT_MAX:
            break
        dp[i][0] = 1
    
    for i in range(1, n):
        for j in range(1, m):
            temp = 0
            if dp[i][j] == INT_MAX:
                continue
            if dp[i-1][j] != INT_MAX:
                temp += dp[i-1][j]
            if dp[i][j-1] != INT_MAX:
                temp += dp[i][j-1]
            dp[i][j] = temp

    answer = dp[n-1][m-1] % 1000000007
            
    return answer
