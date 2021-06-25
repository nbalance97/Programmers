from collections import deque

def solution(number, k):
    stack = deque()
    delcnt = 0
    for i, n in enumerate(number):
        while stack and delcnt != k:
            if stack[-1] < n:
                delcnt += 1
                stack.pop()
            else:
                break
        stack.append(n)
    
    answer = "".join(stack)
    if delcnt < k: # 충분히 지우지 못한 경우 뒤에서부터 지워줌.
        answer = answer[:-(k-delcnt)]
        
    return answer
