def solution(n, s):
    answer = []
    temp = s // n
    p = s
 
    if temp == 0:
        return [-1]
 
    if s % n == 0:
        answer = [temp] * n
    else:
        answer = [temp + 1] * (s % n) + [temp] * (n - (s % n))
 
    answer.sort()
    return answer
