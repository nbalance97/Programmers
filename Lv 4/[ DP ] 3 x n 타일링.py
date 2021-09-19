def solution(n):
    answer = 0
    dp = [1] + [0] * (n)
    
    for i in range(2, n+1):
        dp[i] += (dp[i-2] * 3)
        for j in range(4, i+1, 2):
            dp[i] += (dp[i - j] * 2)
        
        dp[i] = dp[i] % 1000000007
    answer = dp[n]
    return answer
