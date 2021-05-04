def solution(numbers, hand):
    answer = ''
    
    Lx = 4 # 왼손 x,y
    Ly = 1
    Rx = 4 # 오른손 x,y
    Ry = 3
    for num in numbers:
        if num in [1, 4, 7]: # 왼손으로만 눌러야 되는 경우
            answer = answer + "L"
            Lx = num // 3 + 1 # 1,4,7 순서대로 1,2,3으로 변환
            Ly = 1
        elif num in [3, 6, 9]: # 오른손으로만 눌러야 되는 경우
            answer = answer + "R"
            Rx = num // 3 # 3,6,9 순서대로 1,2,3으로 변환
            Ry = 3
        else: # 가운데 버튼의 경우 거리계산 해주어야 함
            Tx = 0
            if num == 0: # 2,5,8,0 순서대로 1,2,3,4로 변환
                Tx = 4
            else:
                Tx = num // 3 + 1
            Ty = 2
            
            if abs(Tx - Lx) + abs(Ty - Ly) < abs(Tx - Rx) + abs(Ty - Ry): # x축 차이 + y축 차이로 거리 계산(왼손, 오른손)
                Lx = Tx
                Ly = 2
                answer = answer + "L"
            elif abs(Tx - Lx) + abs(Ty - Ly) > abs(Tx - Rx) + abs(Ty - Ry):
                Rx = Tx
                Ry = 2
                answer = answer + "R"
            else: # 거리가 같은 경우는 hand를 참고해서 이동
                if hand == "left":
                    Lx = Tx
                    Ly = 2
                    answer = answer + "L"
                else:
                    Rx = Tx
                    Ry = 2
                    answer = answer + "R"
            
    
    return answer
