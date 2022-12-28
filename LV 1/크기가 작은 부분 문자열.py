from collections import deque

def solution(t, p):
    answer = 0
    size, p = len(p), int(p)
    queue = deque()
    
    for ch in t:
        queue.append(ch)
        if len(queue) > size:
            queue.popleft()
        
        if len(queue) == size:
            data = int("".join(queue))
            if data <= p:
                answer += 1
    
    return answer
