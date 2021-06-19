def solution(n, m):
    answer = []
    tot = n * m
    if n > m:
        n, m = m, n
    gcd = 0
    while True:
        t = m % n
        q = m // n
        if t == 0: 
            gcd = n
            break
        m = n
        n = t
    
    lcm = tot // gcd # lcm * gcd = a * b
    answer = [gcd, lcm]
        
    
    return answer
  
# 다른 버전
import math
def solution(n, m):
    return [math.gcd(n,m), n*m//math.gcd(n,m)]
