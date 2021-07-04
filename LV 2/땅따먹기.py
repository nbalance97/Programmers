import copy
def solution(land):
    dp = copy.deepcopy(land)
    
    for i in range(1, len(land)):
        for j in range(len(land[0])):
            for k in range(len(land[0])):
                if k == j:
                    continue
                dp[i][j] = max(dp[i][j], dp[i-1][k] + land[i][j])
                
    return max(dp[len(land)-1])
