import math
        

def solution(number, limit, power):
    answer = 0
    count = [0] * (number + 1)
    
    for i in range(1, number+1):
        for j in range(i, number+1, i):
            count[j] += 1
        
    for i in range(1, number+1):
        if count[i] > limit:
            count[i] = power
    
    return sum(count)
