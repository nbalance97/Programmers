def solution(board):
    answer = 0
    t = 1
    dp = [[0] * len(board[0]) for _ in range(len(board))]
    # dp 초기화
    for i in range(len(board)):
        dp[i][0] = board[i][0]
        answer = max(answer, dp[i][0])
    
    for i in range(len(board[0])):
        dp[0][i] = board[0][i]
        answer = max(answer, dp[i][0])
    
    # dp 
    for i in range(1, len(board)):
        for j in range(1, len(board[0])):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                answer = max(answer, dp[i][j])
        
    answer = answer ** 2
    return answer
