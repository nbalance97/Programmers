def solution(numbers, hand):
    answer = ''
    
    Lx = 4
    Ly = 1
    Rx = 4
    Ry = 3
    for num in numbers:
        if num in [1, 4, 7]:
            answer = answer + "L"
            Lx = num // 3 + 1
            Ly = 1
        elif num in [3, 6, 9]:
            answer = answer + "R"
            Rx = num // 3
            Ry = 3
        else:
            Tx = 0
            if num == 0:
                Tx = 4
            else:
                Tx = num // 3 + 1
            Ty = 2
            
            if abs(Tx - Lx) + abs(Ty - Ly) < abs(Tx - Rx) + abs(Ty - Ry):
                Lx = Tx
                Ly = 2
                answer = answer + "L"
            elif abs(Tx - Lx) + abs(Ty - Ly) > abs(Tx - Rx) + abs(Ty - Ry):
                Rx = Tx
                Ry = 2
                answer = answer + "R"
            else:
                if hand == "left":
                    Lx = Tx
                    Ly = 2
                    answer = answer + "L"
                else:
                    Rx = Tx
                    Ry = 2
                    answer = answer + "R"
            
    
    return answer
