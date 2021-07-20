def solution(routes):
    answer = 1
    routes.sort(reverse=True)
    camera = routes[0][0]
    for i in range(1, len(routes)):
        if routes[i][0] <= camera and camera <= routes[i][1]:
            pass
        else:
            answer += 1
            camera = routes[i][0]
        
    return answer
