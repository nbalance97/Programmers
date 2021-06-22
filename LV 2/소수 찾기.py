from itertools import permutations
import math

def check_prime(n):
    if n <= 1:
        return False
    elif n == 2:
        return True
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True
        
def solution(numbers):
    answer = 0
    visited = set()
    for i in range(1, len(numbers)+1):
        allcase = list(permutations(numbers, i))
        for case in allcase:
            temp = int("".join(case))
            if temp not in visited:
                visited.add(temp)
                if check_prime(temp):
                    answer += 1
    return answer
