from collections import deque

def get_movement(arr, position, org_value, change_value):
    # board의 경우 org_value, change_value가 0, 1
    # table의 경우 org_value, change_value가 1, 0
    
    x, y = position[0], position[1]
    movement = [[x, y]]
    queue = deque([[x, y]])
    arr[x][y] = change_value
    min_x, min_y = x, y
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    length = len(arr)
    
    while queue:
        nx, ny = queue.popleft()
        for i in range(4):
            mx, my = nx + dx[i], ny + dy[i]
            if 0 <= mx < length and 0 <= my < length and arr[mx][my] == org_value:
                arr[mx][my] = change_value
                min_x, min_y = min(mx, min_x), min(my, min_y)
                movement.append([mx, my])
                queue.append([mx, my])
    
    movement = list(map(lambda f:(f[0]-min_x, f[1]-min_y), movement))
    return movement

def get_total_list(arr, f, value):
    length = len(arr)
    total_list = []
    org_value = value
    change_value = 1 if value == 0 else 0
    for i in range(length):
        for j in range(length):
            if arr[i][j] == value:
                total_list.append(f(arr, [i, j], org_value, change_value))
    
    return total_list

def rotate(block):
    max_col = max(map(lambda x:(x[1]), block))
    return list(map(lambda x:(max_col-x[1], x[0]), block))
    

def solution(game_board, table):
    answer = 0
    total_blank = get_total_list(game_board, get_movement, 0)
    total_block = get_total_list(table, get_movement, 1)
    used = [False] * len(total_block)
    for idx1, blank in enumerate(total_blank):
        for idx2, block in enumerate(total_block):
            if used[idx2] or len(blank) != len(block):
                continue
            
            temp = block
            find = False
            for i in range(4):
                temp = rotate(temp)
                if len(set(temp) & set(blank)) == len(temp):
                    find = True
                    break
            
            if find:
                used[idx2] = True
                answer += len(block)
                break

    return answer
