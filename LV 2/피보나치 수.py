def solution(n):
    answer = 0
    a = 0
    b = 1
    c = 1
    if n == 1:
        return 1
    
    for i in range(2, n+1):
        c = a + b
        a = b
        b = c
    
    answer = c % 1234567
    return answer
