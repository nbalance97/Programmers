from collections import deque

def solution(ingredient):
    answer = 0
    
    sequence = [1, 2, 3, 1]
    stack = deque()
    
    for i in ingredient:
        stack.append(i)
        
        while len(stack) >= 4 and stack[-4] == 1 and stack[-3] == 2 and stack[-2] == 3 and stack[-1] == 1:
            for _ in range(4):
                stack.pop()
            answer += 1
    
    return answer
