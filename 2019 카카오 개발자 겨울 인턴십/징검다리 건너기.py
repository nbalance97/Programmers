def chk_ans(stones, weight):
    zero_count = 0
    continuous_zero = 0
    
    for st in stones:
        if st < weight: # 기준선보다 돌의 무게가 작다면 0이라고 가정
            zero_count = zero_count + 1
        else: 
            continuous_zero = max(continuous_zero, zero_count)
            zero_count = 0
    
    return max(continuous_zero, zero_count)
    

def solution(stones, k):
    answer = 0
    stone = list(set(stones))
    stone.sort()
    left = 0
    right = len(stone)-1

    while right < len(stone) and left<=right:
        mid = (left + right) // 2
        check = chk_ans(stones, stone[mid])
        if check >= k:
            right = mid-1
        else:
            answer = stone[mid]
            left = mid+1
            
    return answer
