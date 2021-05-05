def solution(gems):
    answer = []
    total_gems = set(gems)
    gems = [''] + gems
    mid_answer = dict()
    current_gems = set()
    left = 1
    right = 1
    ans_left = 1
    ans_right = len(gems)
    
    if len(total_gems) == 1: # 보석이 한개인 경우는 예외 케이스
        return [1, 1]
    
    while True:
        while right < len(gems) and len(current_gems) != len(total_gems): # 오른쪽으로 이동(모든 보석 포함할때까지)
            current_gems.add(gems[right])
            try:
                mid_answer[gems[right]] = mid_answer[gems[right]] + 1
            except:
                mid_answer[gems[right]] = 1
            right = right + 1
        
        while left < len(gems) and mid_answer[gems[left]] > 1: # 왼쪽 구간 오른쪽으로 이동(보석 뺄수 있을때까지)
            mid_answer[gems[left]] = mid_answer[gems[left]] - 1
            left = left + 1
        
        if len(current_gems) != len(total_gems):
            break
        
        if ans_right - ans_left > right - left: # 정답 갱신될때마다 저장.
            # 구간이 같을때는 왼쪽에 있어야 하므로 >로 함. 구간 길이 같을때는 기존 정답 유지
            ans_left = left
            ans_right = right

        current_gems.discard(gems[left])
        mid_answer[gems[left]] = mid_answer[gems[left]] - 1
        left = left + 1

    
    answer = [ans_left, ans_right-1] # 값 보정 해줌(right 한칸 튀어나와 있음)
    return answer
