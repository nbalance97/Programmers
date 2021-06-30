def solution(dirs):
    answer = 0

    path = set()
    pos = [5, 5]
    for d in dirs:
        if d == 'U' and pos[0] > 0:
            if tuple([pos[0], pos[1], pos[0]-1, pos[1]]) not in path:
                path.add(tuple([pos[0], pos[1], pos[0]-1, pos[1]]))
                path.add(tuple([pos[0]-1, pos[1], pos[0], pos[1]]))
                answer += 1
            pos[0] -= 1
        elif d == 'L' and pos[1] > 0:
            if tuple([pos[0], pos[1], pos[0], pos[1]-1]) not in path:
                path.add(tuple([pos[0], pos[1], pos[0], pos[1]-1]))
                path.add(tuple([pos[0], pos[1]-1, pos[0], pos[1]]))
                answer += 1
            pos[1] -= 1
        elif d == 'R' and pos[1] < 10:
            if tuple([pos[0], pos[1], pos[0], pos[1]+1]) not in path:
                path.add(tuple([pos[0], pos[1], pos[0], pos[1]+1]))
                path.add(tuple([pos[0], pos[1]+1, pos[0], pos[1]]))
                answer += 1
            pos[1] += 1
        elif d == 'D' and pos[0] < 10: 
            if tuple([pos[0], pos[1], pos[0]+1, pos[1]]) not in path:
                path.add(tuple([pos[0], pos[1], pos[0]+1, pos[1]]))
                path.add(tuple([pos[0]+1, pos[1], pos[0], pos[1]]))
                answer += 1
            pos[0] += 1
    return answer
