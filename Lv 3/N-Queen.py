answer = 0
def check(x1, y1, x2, y2):
    if abs(y2 - y1) == abs(x2 - x1):
        return True
    else:
        return False

def queen(current, row, n):
    global answer

    if row == n:
        answer += 1
        return
    
    for i in range(n):
        skip = False
        for x1, y1 in current:
            if y1 == i or check(row, i, x1, y1):
                skip = True
                break
                
        if not skip:
            queen(current+[[row, i]], row+1, n)
    
    return

def solution(n):
    global answer
    queen([], 0, n)
    return answer
