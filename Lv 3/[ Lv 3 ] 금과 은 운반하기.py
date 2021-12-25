def solution(a, b, g, s, w, t):
    answer = int(10**16)
    left, right = 0, int(10**16)
    
    while left <= right:
        mid = (left + right) // 2
        gold = 0
        silver = 0
        total = 0
        for i in range(len(g)):
            movement_count = mid // (t[i] * 2)
            if mid % (t[i] * 2) >= t[i]:
                movement_count += 1
            city_gold = w[i] * movement_count if w[i] * movement_count <= g[i] else g[i]
            city_silver = w[i] * movement_count if w[i] * movement_count <= s[i] else s[i]
            gold += city_gold
            silver += city_silver
            total += w[i] * movement_count if s[i] + g[i] >= w[i] * movement_count else s[i] + g[i]

        if gold >= a and silver >= b and total >= a + b:
            right = mid - 1
            answer = min(answer, mid)
        else:
            left = mid + 1
        
    return answer
