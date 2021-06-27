from collections import deque

def check(board, m, n):
    dx = [0, 0, 1, 1]
    dy = [0, 1, 0, 1]
    ch = board[m][n]
    count = 0
    for i in range(4):
        x = m + dx[i]
        y = n + dy[i]
        if x >= 0 and x <= len(board)-1 and y >= 0 and y <= len(board[0])-1:
            if board[x][y] == ch:
                count += 1
    
    if count == 4:
        return True
    return False

def remove(board, m, n):
    dx = [0, 0, 1, 1]
    dy = [0, 1, 0, 1]
    for i in range(4):
        board[m+dx[i]][n+dy[i]] = '-'
    
def solution(m, n, board):
    board = [list(b) for b in board]
    answer = 0
    
    while True:
        currect = []
        # 2x2 검사
        for i in range(m):
            for j in range(n):
                if board[i][j] == '-':
                    continue
                if check(board, i, j):
                    currect.append([i, j])

        if len(currect) == 0:
            # -의 개수 구해줌
            for b in board: 
                answer += b.count('-')
            break
            
        # 검사결과 제거
        for cur in currect:
            remove(board, cur[0], cur[1])

        # - 붙여주는 과정
        columns = [[] for _ in range(n)]
        for j in range(n):
            for i in range(m):
                if board[i][j] != '-':
                    columns[j].append(board[i][j])
            if len(columns[j]) < m:
                columns[j] = ['-'] * (m - len(columns[j])) + columns[j] # 길이 '-' 붙여서 맞추어줌
        

        # - 제거한걸 원래 board에 적용
        for i in range(m):
            for j in range(n):
                board[i][j] = columns[j][i]
                
    return answer
