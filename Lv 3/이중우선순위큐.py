import heapq
def solution(operations):
    answer = []
    max_heap = []
    min_heap = []
    remove_set = set()
    index = 0
    for op in operations:
        temp = op.split()
        operation = temp[0]
        number = int(temp[1])
        if operation == 'I':
            heapq.heappush(min_heap, [number, index])
            heapq.heappush(max_heap, [-number, index])
            index += 1
        elif operation == 'D':
            if number == -1:
                while min_heap:
                    number, idx = heapq.heappop(min_heap)
                    if idx not in remove_set:
                        remove_set.add(idx)
                        break
                        
            elif number == 1:
                while max_heap:
                    number, idx = heapq.heappop(max_heap)
                    if idx not in remove_set:
                        remove_set.add(idx)
                        break
        
    while min_heap:
        if min_heap[0][1] in remove_set:
            heapq.heappop(min_heap)
        else:
            break

    while max_heap:
        if max_heap[0][1] in remove_set:
            heapq.heappop(max_heap)
        else:
            break

    if len(min_heap) == 0:
        return [0, 0]
    else:
        return [-max_heap[0][0], min_heap[0][0]]
    return answer
