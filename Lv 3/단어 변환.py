from collections import deque

def compare(a, b):
    count = 0
    for i in range(len(a)):
        if a[i] == b[i]:
            count += 1
    
    if count == len(a)-1:
        return True
    else:
        return False
    
def solution(begin, target, words):
    answer = 0
    
    visited = set()
    queue = deque()
    queue.append([begin, 0])
    visited.add(begin)
    while queue:
        wd,count = queue.popleft()
        if wd == target:
            answer = count
            break
        for word in words:
            if not word in visited and compare(wd, word):
                queue.append([word, count+1])
                visited.add(word)

    return answer
