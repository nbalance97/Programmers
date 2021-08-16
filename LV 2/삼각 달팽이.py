def solution(n):
    lists = [[0] * i for i in range(1, n+1)]
    idx = 1
    i = 0
    while True:
        x = 2 * i
        y = i
        i += 1
        
        # 아래 내려가는 부분
        while x < n and lists[x][y] == 0:
            lists[x][y] = idx
            x += 1
            idx += 1
        x -= 1
        
        # 오른쪽 진행
        y += 1
        while y < x+1 and lists[x][y] == 0:
            lists[x][y] = idx
            y += 1
            idx += 1
        y -= 1
        
        # 대각선 왼쪽 위 진행
        x -= 1; y -= 1
        while lists[x][y] == 0:
            lists[x][y] = idx
            x -= 1
            y -= 1
            idx += 1
        
        # 전체 체크
        end = True
        for l in lists:
            for e in l:
                if e == 0:
                    end = False
                    break
            if not end:
                break
        
        if end:
            break

    answer = []
    
    # 정답 저장
    for l in lists:
        for e in l:
            answer.append(e)
    return answer
