def check(a, b, c, d):
    return (a*d) - (b*c) != 0

def get_xy(a, b, e, c, d, f):
    if ((b * f) - (e * d)) % ((a * d) - (b * c)) != 0 or \
       ((e * c) - (a * f)) % ((a * d) - (b * c)) != 0:
            return (-int(10e9), -int(10e9))
    
    x = ((b * f) - (e * d)) // ((a * d) - (b * c))
    y = ((e * c) - (a * f)) // ((a * d) - (b * c))
    
    return (x, y)

def solution(line):
    answer = []
    point_set = set()
    matrix = [['.'] * 1001 for _ in range(1001)] 
    min_x, max_x = int(10e9), -int(10e9)
    min_y, max_y = int(10e9), -int(10e9)
    
    for i in range(len(line)):
        for j in range(i):
            if check(line[i][0], line[i][1], line[j][0], line[j][1]):
                x, y = get_xy(line[i][0], line[i][1], line[i][2],
                             line[j][0], line[j][1], line[j][2])
                
                if x == -int(10e9):
                    continue
                
                if (x, y) not in point_set:
                    min_x, max_x = min(min_x, x), max(max_x, x)
                    min_y, max_y = min(min_y, y), max(max_y, y)
                    point_set.add((x, y))
    
    print(point_set)
    
    for x, y in point_set:
        if y - min_y <= 1000 and x - min_x <= 1000:
            matrix[y-min_y][x-min_x] = '*'
        
    max_y = max_y - min_y
    max_x = max_x - min_x
    
    for i in range(max_y, -1, -1):
        answer.append("".join(matrix[i][:max_x+1]))
        
    return answer
