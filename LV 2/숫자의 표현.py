def solution(n):
    answer = 0
    start = 0
    finish = 1
    sumation = 1
    while True:
        if start == finish:
            break
        if n > sumation:
            finish += 1
            sumation += finish
        elif n == sumation:
            print(start, finish)
            answer += 1
            finish += 1
            sumation += finish
        else:
            start += 1
            sumation -= start
    
    return answer
