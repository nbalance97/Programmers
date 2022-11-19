import math

def gcd(a, b):
    rA, rB = max(a, b), min(a, b)
    while True:
        temp = rA % rB
        if temp == 0:
            return rB
        rA, rB = rB, rA % rB
        
def divisor(a):
    d = set()
    for i in range(1, int(math.sqrt(a)) + 1):
        if a % i == 0:
            d.add(i)
            d.add(a // i)
    
    return d
            

def solution(arrayA, arrayB):
    answer = 0
    a_gcd, b_gcd = arrayA[0], arrayB[0]
    for i in range(1, len(arrayA)):
        a_gcd = gcd(a_gcd, arrayA[i])
    for i in range(1, len(arrayB)):
        b_gcd = gcd(b_gcd, arrayB[i])
    
    a_d = divisor(a_gcd)
    b_d = divisor(b_gcd)
    common = a_d & b_d
    a_candidate = (a_d - common) 
    b_candidate = (b_d - common)
    
    for ac in a_candidate:
        for b in arrayB:
            if b % ac == 0:
                break
        else:
            answer = max(answer, ac)
    
    for bc in b_candidate:
        for a in arrayA:
            if a % bc == 0:
                break
        else:
            answer = max(answer, bc)
    
    return answer
