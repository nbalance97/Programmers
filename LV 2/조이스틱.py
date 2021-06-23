def get_distance(c):
    p1 = abs(ord(c) - ord('A')) # 정방향
    p2 = abs(ord('Z') - ord(c) + 1) # 역방향
    return min(p1, p2)

def get_next(arr, idx):
    p = idx
    right_move = 0
    while True:
        p = (p + 1) % len(arr)
        right_move += 1
        if arr[p] != 0:
            break
    
    t = idx
    left_move = 0
    while True:
        t = (t - 1) % len(arr)
        left_move += 1
        if arr[t] != 0:
            break
    
    if right_move <= left_move:
        return (p, right_move)
    else:    
        return (t, left_move)
    
    

def solution(name):
    answer = 0

    distance = [0] * len(name)
    for i, p in enumerate(name):
        distance[i] = get_distance(p)
    
    answer = distance[0]
    distance[0] = 0
    idx = 0
    while sum(distance) != 0:
        idx, movement = get_next(distance, idx)
        answer += movement
        answer += distance[idx]
        distance[idx] = 0

    return answer
