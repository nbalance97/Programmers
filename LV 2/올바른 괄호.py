from collections import deque

def solution(s):
    queue = deque()
    for c in s:
        if c == '(':
            queue.append('(')
        else:
            if len(queue) == 0:
                return False
            queue.popleft()
    
    if queue:
        return False
    
    return True
