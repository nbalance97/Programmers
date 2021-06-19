import math
def solution(n):
    odd = [True] * 1000001
    odd[1] = False
    odd[0] = False
    for i in range(2, int(math.sqrt(1000000))+1):
        if odd[i] == False:
            continue
        for j in range(i*2, 1000001, i): # 배수들 검사
            odd[j] = False
            
    answer = 0
    for i in range(1, n+1):
        if odd[i] == True:
            answer += 1

    return answer
