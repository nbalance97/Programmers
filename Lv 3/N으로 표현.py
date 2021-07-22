from collections import deque


def solution(N, number):
    answer = -1
    table = []
    for i in range(1, 9):
        middle_set = set()
        middle_set.add(int(str(N) * i)) # 쭉 붙인거는 따로 추가
        for j in range(0, i-1):
            for k in table[j]:
                for l in table[-j-1]:
                    middle_set.add(k + l)
                    middle_set.add(k - l)
                    middle_set.add(k * l)
                    if l != 0:
                        middle_set.add(k // l)
        if number in middle_set:
            return i
        table.append(middle_set)

            
    return answer
