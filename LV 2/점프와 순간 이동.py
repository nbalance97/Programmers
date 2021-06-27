from collections import deque

def solution(n):
    count = 0
    while True:
        if n % 2 == 1:
            n = n - 1
            count += 1
        else:
            n = n // 2
        
        if n == 0:
            break
    
    return count
