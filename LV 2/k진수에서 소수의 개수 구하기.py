import math
import re

def convert(n, k):
    cv = ""
    while n != 0:
        cv = str(n % k) + cv
        n //= k
    
    return cv

def check_prime(n):
    if n == 1:
        return False
    
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
        
    return True

def solution(n, k):
    PATTERN = r"0+"
    answer = 0
    convert_string = convert(n, k)
    st_list = re.split(PATTERN, convert_string)
    
    for st in st_list:
        if st == "":
            continue
        if check_prime(int(st)):
            answer += 1
        
    return answer
