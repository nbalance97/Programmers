end_flag = False
answer = []

def dfs(tickets, visited, city):
    global end_flag, answer
    if len(visited) == len(tickets):
        answer.append(city)
        end_flag = True
        return

    for i in range(len(tickets)):
        if tickets[i][0] == city and i not in visited:
            visited.add(i)
            answer.append(tickets[i][0])
            dfs(tickets, visited, tickets[i][1])
            if end_flag:
                return
            answer.pop()
            visited.remove(i)
        

def solution(tickets):
    global answer
    tickets.sort(key=lambda x:x[1])
    dfs(tickets, set(), "ICN")
    
    return answer
