def solution(n, times):
    answer = 9999999999
    r = max(times) * n
    l = 0
    
    while (l <= r):
        m = (l + r) // 2
        tot = 0
        for time in times:
            tot += (m // time)        

        if tot >= n:
            answer = m
            r = m - 1
        else:
            l = m + 1
    
    return answer
