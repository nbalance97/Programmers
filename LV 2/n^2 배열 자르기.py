def solution(n, left, right):
    answer = []
    sr, sc = (left // n)+1, (left % n)+1
    er, ec = (right // n)+1, (right % n)+1
    if sr == er:
        for j in range(sc, ec+1):
            if j <= sr:
                answer.append(sr)
            else:
                answer.append(j)
        return answer
    else:
        for j in range(sc, n+1):
            if j <= sr:
                answer.append(sr)
            else:
                answer.append(j)
                
    for i in range(sr+1, er):
        for j in range(1, n+1):
            if j <= i:
                answer.append(i)
            else:
                answer.append(j)
    
    for j in range(1, ec+1):
        if j <= er:
            answer.append(er)
        else:
            answer.append(j)
            

    return answer
