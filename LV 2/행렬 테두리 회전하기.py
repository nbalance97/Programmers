def rotate(matrix, x1, y1, x2, y2):
    minvalue = 999999999
    last = matrix[x1][y1]
    
    for i in range(x1, x2):
        matrix[i][y1] = matrix[i+1][y1]
        minvalue = min(minvalue, matrix[i+1][y1])
        
    for j in range(y1, y2):
        matrix[x2][j] = matrix[x2][j+1]
        minvalue = min(minvalue, matrix[x2][j+1])
    
    for i in range(x2-1, x1-1, -1):
        matrix[i+1][y2] = matrix[i][y2]
        minvalue = min(minvalue, matrix[i][y2])
        
    for j in range(y2-1, y1, -1):
        matrix[x1][j+1] = matrix[x1][j]
        minvalue = min(minvalue, matrix[x1][j])
        
    matrix[x1][y1+1] = last
    minvalue = min(minvalue, last)
    return minvalue
    
def solution(rows, columns, queries):
    answer = []
    
    matrix = [[0] * (columns + 1) for _ in range(rows + 1)]
    for i in range(1, rows+1):
        for j in range(1, columns+1):
            matrix[i][j] = columns*(i-1)+j
    
    for query in queries:
        answer.append(rotate(matrix, query[0], query[1], query[2], query[3]))
    
    return answer
