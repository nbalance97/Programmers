def solution(array, commands):
    answer = []
    for a, b, c in commands:
        temp = array[a-1:b]
        temp.sort()
        answer.append(temp[c-1])
    
    return answer
  
  # 문제를 잘 보고 인덱스를 잘 맞추어줘야 함..
