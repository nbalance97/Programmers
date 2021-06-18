def get_three(n):
    p = n
    conv = ''
    while p != 0:
        conv = str(p % 3) + conv
        p = p // 3
    return conv
        

def solution(n):
    answer = 0
    temp = get_three(n)[::-1] # 3진수 변환 / 앞뒤 반전
    answer = int(temp, base=3) # 3진수 값 저장
    return answer
