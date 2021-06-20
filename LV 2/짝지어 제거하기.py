from collections import deque
def solution(s):
    stack = deque()
    
    for c in s:
        if len(stack) == 0:
            stack.append(c)
        else:
            if stack[-1] == c:
                stack.pop()
            else:
                stack.append(c)
                
    answer = 0 if stack else 1
    return answer
