def getonecount(n):
    result = 0
    while(n > 0):
        if n%2 == 1:
            result += 1
        n = n // 2
    return result

def solution(n):
    answer = 0
    oc = getonecount(n)
    for i in range(n+1, 1000000):
        if oc == getonecount(i):
            answer = i
            break
    
    return answer
