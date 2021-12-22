def solution(sticker):
    answer = 0
    dp = [[0] * 2 for _ in range(len(sticker))]
    
    if len(sticker) == 1:
        return sticker[0]
    
    # 첫번째 선택
    dp[0][0], dp[0][1] = 0, sticker[0]
    dp[1][0], dp[1][1] = sticker[0], 0
    for i in range(2, len(sticker)):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        dp[i][1] = dp[i-1][0] + sticker[i]
    answer = max(answer, max(dp[len(sticker)-2]))
    
    # 첫번째 선택하지 않은 경우
    dp[0][0], dp[0][1] = 0, 0
    dp[1][0], dp[1][1] = 0, sticker[1]
    for i in range(2, len(sticker)):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        dp[i][1] = dp[i-1][0] + sticker[i]
    answer = max(answer, max(dp[len(sticker)-1]))
    
    return answer
