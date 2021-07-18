def hanoii(answer, n, src, temp, dest):
    if n == 1:
        answer.append([src, dest])
    else:
        hanoii(answer, n-1, src, dest, temp)
        answer.append([src, dest])
        hanoii(answer, n-1, temp, src, dest)

def solution(n):
    answer = []
    hanoii(answer, n, 1, 2, 3)
    return answer
