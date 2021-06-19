import math
def solution(n):
    answer = 0
    if n == 0:
        answer = 0
    elif n == 1:
        answer = 1
    else:
        for i in range(1, int(math.sqrt(n))+1):
            if n % i == 0:
                if i != n // i:
                    answer += (i + (n // i))
                else:
                    answer += i
    return answer
