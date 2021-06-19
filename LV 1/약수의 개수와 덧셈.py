def solution(left, right):
    count = [0] * 1001 # 약수의 개수 저장
    answer = 0
    # 현재 숫자의 배수들을 모두 약수의 개수 + 1개 해주는 방식으로 전체 약수의 개수 저장
    for i in range(1, 1001): 
        for j in range(i, 1001, i):
            count[j] += 1
    
    for i in range(left, right+1):
        if count[i] % 2 == 1:
            answer -= i
        else:
            answer += i
            
    return answer
