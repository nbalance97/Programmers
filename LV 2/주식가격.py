from collections import deque

def solution(prices):
    answer = [0] * len(prices)
    stack = deque()
    
    for idx in range(len(prices)):
        while stack:
            if prices[stack[-1]] > prices[idx]:
                i = stack.pop()
                answer[i] = idx - i
            else:
                break
                
        stack.append(idx)
    
    while stack:
        i = stack.pop()
        answer[i] = len(prices) - i - 1
        
    return answer
