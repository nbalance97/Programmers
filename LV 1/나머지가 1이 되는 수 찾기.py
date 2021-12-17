def solution(n):
    return min([i for i in range(1, n+2) if n % i == 1])
