def convert_four(n):
    s = ''
    idx = 0
    while n != 0: 
        remainder = n % 3
        q = n // 3
        if n % 3 == 0:
            remainder = 4
            q = q - 1
        s = str(remainder) + s
        n = q

    return s

def solution(n):
    answer = ''
    k = convert_four(n)
    answer = k
    return answer
