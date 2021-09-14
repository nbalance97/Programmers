def solution(distance, rocks, n):
    answer = 0
    left = 0
    rocks.sort()
    right = int(10e8)+1
    
    # mid를 최솟값이라고 할 때
    while left <= right:
        mid = (left + right) // 2
        prev = 0
        eliminated_count = 0
        for i in range(len(rocks)):
            if rocks[i] - prev < mid:
                eliminated_count += 1
            else:
                prev = rocks[i]
        
        if distance - prev < mid: # 도착 거리
            eliminated_count += 1
        
        if eliminated_count <= n:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1
            
    return answer
