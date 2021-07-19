import heapq
import math
def convert_second(s):
    hour = int(s[0:2])
    minute = int(s[3:5])
    second = int(s[6:8])
    msecond = int(s[9:]) / 1000
    return 4 + 3600 * hour + 60 * minute + second + msecond
    

def solution(lines):
    answer = 0
    cv_list = []
    for line in lines:
        temp = line.split()
        end = convert_second(temp[1])
        start = round(end - float(temp[2][:-1]) + 0.001, 3)
        cv_list.append([start, end])
        
    cv_list.sort()
    
    heap = []
    for start, end in cv_list:
        heapq.heappush(heap, [end, start])
        while heap:
            if heap[0][0] + 1 <= start:
                heapq.heappop(heap)
            else:
                break
        answer = max(answer, len(heap))
    
    return answer
