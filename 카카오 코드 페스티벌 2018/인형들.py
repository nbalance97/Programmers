import sys

input = sys.stdin.readline
n, k = map(int, input().rstrip().split())
numbers = list(map(int, input().rstrip().split()))

answer = sys.maxsize

sumation = [0] * n

for j in range(k, n+1):
    for i in range(len(numbers) - j + 1):
        dest = numbers[i:i+j]
        p = sum(dest) 
        avg = p / j
        answer = min((sum(map(lambda x:(x-avg) ** 2, dest)) / j) ** 0.5,
                     answer)
print(answer)
    
    
