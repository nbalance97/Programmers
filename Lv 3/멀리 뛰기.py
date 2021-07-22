def solution(n):
    answer = 0
    dp = [1] + [0] * n
    for i in range(1, n+1):
        if i-1 >= 0:
            dp[i] += dp[i-1]
        if i-2 >= 0:
            dp[i] += dp[i-2]
    answer = dp[n] % 1234567

    return answer
