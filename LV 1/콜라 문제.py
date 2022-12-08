def solution(a, b, n):
    answer = 0
    remainder = 0
    
    while n >= a or remainder >= a:
        remainder += n % a
        answer += (n // a) * b
        n = (n // a) * b
        
        if n < a:
            remainder += n
            n = 0
        
        if remainder >= a:
            answer += (remainder // a) * b
            remainder = (remainder // a) * b + remainder % a
            
    return answer
