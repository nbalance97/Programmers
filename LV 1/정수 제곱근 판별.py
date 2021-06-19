import math

def solution(n):
    answer = 0
    p = math.sqrt(n)
    if p == math.floor(p):
        answer = (int(p) + 1) ** 2 
    else:
        answer = -1
    
    return answer
