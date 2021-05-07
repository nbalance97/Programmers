from collections import deque
import sys

def bfs(board, x, y):
    INT_MAX = sys.maxsize
    answer = INT_MAX
    current = deque()
    height_pay = [[INT_MAX] * len(board) for _ in range(len(board))] # 현재 위치에 ㅣ로 도착했을때 비용
    width_pay = [[INT_MAX] * len(board) for _ in range(len(board))] # 현재 위치에 ㅡ로 도착했을때 비용
    height_pay[0][0] = 0
    width_pay[0][0] = 0
    current.append([x, y, "ud"])
    current.append([x, y, "lr"])
    
    length = len(board)
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while current:
        cX, cY, direction = current.popleft()
        if cX == length-1 and cY == length-1:
            answer = min(answer, height_pay[cX][cY], width_pay[cX][cY])
            continue
        
        for i in range(2): # up-down
            nX = cX + dx[i]
            nY = cY + dy[i]
            if 0 <= nX and nX < length and 0 <= nY and nY < length:
                if board[nX][nY] == 1:
                    continue
                if direction == "ud":
                    newPay = height_pay[cX][cY] + 100
                else:
                    newPay = width_pay[cX][cY] + 600
                if height_pay[nX][nY] > newPay:
                    height_pay[nX][nY] = newPay
                    current.append([nX, nY, "ud"])
                    
        for i in range(2, 4): # left-right
            nX = cX + dx[i]
            nY = cY + dy[i]
            if 0 <= nX and nX < length and 0 <= nY and nY < length:
                if board[nX][nY] == 1:
                    continue
                if direction == "lr":
                    newPay = width_pay[cX][cY] + 100
                else:
                    newPay = height_pay[cX][cY] + 600
                if width_pay[nX][nY] > newPay:
                    width_pay[nX][nY] = newPay
                    current.append([nX, nY, "lr"])
    return answer

def solution(board):
    answer = bfs(board, 0, 0)
    return answer
