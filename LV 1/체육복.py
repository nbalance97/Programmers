def solution(n, lost, reserve):
    answer = n
    lost.sort()
    losts = sorted(set(lost))
    reserves = set(reserve)

    for i in losts:
        if i in reserves: # 본인이 여분이 있으면 continue
            continue
        
        if i - 1 == 0:  # 왼쪽 친구에게 빌리기
            pass
        else:
            if i - 1 in reserves and i - 1 not in losts:
                reserves.remove(i-1)
                continue
        
        if i + 1 > n: # 오른쪽 친구에게 빌리기
            pass
        else:
            if i + 1 in reserves and i + 1 not in losts:
                reserves.remove(i+1)
                continue
        
        answer = answer - 1 # 둘다 안되면 해당 인원은 못들음
    
    return answer
