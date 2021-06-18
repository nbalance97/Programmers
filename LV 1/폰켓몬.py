def solution(nums):
    answer = 0
    p = len(nums) // 2
    r = len(set(nums))
    
    if p <= r:
        answer = p
    else:
        answer = r
    
    return answer
