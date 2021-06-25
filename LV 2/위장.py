def solution(clothes):
    answer = 1
    clo = {}
    for cloth, types in clothes:
        if clo.get(types) == None: 
            clo[types] = 0
        clo[types] += 1
    
    p = clo.values()
    for i in p:
        answer *= (i+1)

    return answer - 1
