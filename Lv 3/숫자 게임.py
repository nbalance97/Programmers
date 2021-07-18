from collections import deque

def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    B_queue = deque(B)
    
    for a in A:
        while B_queue:
            b = B_queue.popleft()
            if b > a:
                answer += 1
                break
        
        if not B_queue:
            break
        
    
    return answer
