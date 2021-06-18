def solution(answers):
    answer = []
    n1 = [0] + [1, 2, 3, 4, 5] * 2000
    n2 = [0] + [2, 1, 2, 3, 2, 4, 2, 5] * 1250
    n3 = [0] + [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 1000
    
    correct = [0] * 3
    for i, x in enumerate(answers):
        correct[0] = correct[0] + 1 if n1[i+1] == x else correct[0]
        correct[1] = correct[1] + 1 if n2[i+1] == x else correct[1]
        correct[2] = correct[2] + 1 if n3[i+1] == x else correct[2]
    
    temp = max(correct)
    for i, c in enumerate(correct):
        if c == temp:
            answer.append(i+1)

    return answer
