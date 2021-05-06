from collections import deque

def solution(board, moves):
    answer = 0
    board_queue = [deque() for _ in range(len(board))]
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] != 0:
                board_queue[j].append(board[i][j]) # 각 열에 따른 queue 만들어줌
    
    bucket = deque()

    for mv in moves:
        idx = mv-1
        if len(board_queue[idx]) == 0: # 텅 빈경우는 continue
            continue
    
        target = board_queue[idx].popleft() # 해당 열에서 맨 위의 요소 popleft 해줌
    
        if len(bucket) == 0: # 텅 빈 경우는 왼쪽에 추가
            bucket.appendleft(target)
        else: 
            if bucket[0] == target: # 버킷의 맨 위 요소와 현재 버킷에 넣으려는 요소 비교해서 같으면 버킷의 맨위 요소 빼고 정답에 2 추가
                bucket.popleft()
                answer = answer + 2
            else: # 아니라면 그냥 추가
                bucket.appendleft(target)
                
    return answer
