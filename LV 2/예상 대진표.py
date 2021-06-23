def solution(n,a,b):
    answer = 1
    
    while True:
        if a % 2 == 1:
            a = a + 1
        if b % 2 == 1:
            b = b + 1
        if a == b:
            break
        answer += 1
        a = a // 2
        b = b // 2
        

    return answer
