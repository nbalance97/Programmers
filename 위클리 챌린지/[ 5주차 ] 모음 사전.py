dictionary = []
 
def recursion(p, step):
    if step == 6:
        return
    if p != '':
        dictionary.append(p)
    for c in ['A', 'E', 'I', 'O', 'U']:
        recursion(p+c, step+1)
 
def solution(word):
    answer = 0
    recursion('', 0)
    for i in range(len(dictionary)):
        if dictionary[i] == word:
            answer = i+1
            break
 
    return answer
