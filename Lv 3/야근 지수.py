from collections import deque

def solution(n, works):
    answer = 0
    cut = 0
    flag = False
    works.sort(reverse=True)
    m_height = works[0]
    for height in range(m_height, 0, -1): 
    # 작업량을 높이로 두고 한층씩 잘라가면서 생각
        for i in range(len(works)):
            if works[i] == height:
                cut += 1
                works[i] -= 1
                if cut == n: # n개 자르면 종료
                    flag = True
                    break
            else: 
                # 내림차순 정렬했으므로 높이보다 작아지면 바로 break
                break
        if flag:
            break

    for work in works:
        answer += work * work
    
    return answer
