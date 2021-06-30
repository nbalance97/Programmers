import sys

count = [0, 0]

sys.setrecursionlimit(10**6)

def check(arr, x1, y1, x2, y2):
    t = arr[x1][y1]
    for i in range(x1, x2+1):
        for j in range(y1, y2+1):
            if arr[i][j] != t:
                return False
    
    return True

def f(arr, x1, y1, x2, y2):
    print(x1, y1, x2, y2)
    if check(arr, x1, y1, x2, y2):
        t1 = arr[x1][y1]
        count[t1] += 1
        return
    
    if x1 == x2 and y1 == y2:
        count[arr[x1][y1]] += 1
        return
    
    midX = (x1 + x2) // 2
    midY = (y1 + y2) // 2
    
    f(arr, x1, y1, midX, midY) # 왼위
    f(arr, midX+1, y1, x2, midY) # 왼아
    f(arr, midX+1, midY+1, x2, y2) # 오아
    f(arr, x1, midY+1, midX, y2) # 오위
    
    

def solution(arr):
    answer = []
    t = len(arr)
    f(arr, 0, 0, t-1, t-1)
    return count

