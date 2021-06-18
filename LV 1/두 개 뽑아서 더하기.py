def solution(numbers):
    temp = set()
    
    for i1, t1 in enumerate(numbers):
        for i2, t2 in enumerate(numbers):
            if i1 != i2:
                temp.add(t1 + t2)
    
    answer = list(temp)
    answer.sort()
    
    return answer
