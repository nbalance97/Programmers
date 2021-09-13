from collections import deque

def solution(enter, leave):
    answer = [0] * (len(enter) + 1)
    leave = deque(leave)
    visited = set()
    
    for e_person in enter:
        visited.add(e_person)
        while leave:
            if leave[0] in visited:
                answer[leave[0]] += (len(visited) - 1)
                visited.remove(leave.popleft())
                for left_person in visited:
                    answer[left_person] += 1
            else:
                break
    
    return answer[1:]
