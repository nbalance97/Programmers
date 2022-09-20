import sys

def solution(a):
    answer = 0
    left_min = [sys.maxsize] * len(a)
    right_min = [sys.maxsize] * len(a)
    
    for i in range(1, len(a)):
        left_min[i] = min(left_min[i-1], a[i-1])
        right_min[len(a) - i - 1] = min(right_min[len(a) - i], 
                                        a[len(a) - i])
    
    for i in range(0, len(a)):
        if a[i] < left_min[i] or a[i] < right_min[i]:
            answer += 1
    
    return answer
