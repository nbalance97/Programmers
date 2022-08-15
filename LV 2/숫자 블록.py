import math

def find_block(sequence):
    for i in range(2, math.ceil(math.sqrt(sequence)) + 2):
        if sequence != i and sequence % i == 0:
            if sequence / i > 10000000:
                continue
            else:
                return sequence / i
    
    return 1

def solution(begin, end):
    answer = []
    for i in range(begin, end+1):
        if i == 1:
            answer.append(0)
        else:
            answer.append(find_block(i))
        
    return answer
