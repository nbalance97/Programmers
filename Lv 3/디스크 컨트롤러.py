import heapq

def solution(jobs):
    answer = 0
    heap = []
    
    jobs.sort()
    currentTime = jobs[0][0]; # 초기 작업의 시간으로 세팅
    jobidx = 1
    
    # 작업 시간을 기준으로 최소 히프 구성
    heapq.heappush(heap, [jobs[0][1], jobs[0][0]])
    
    while heap:
        # 현재 기준 최소 시간의 작업 가져옴
        jobtime, arrive = heapq.heappop(heap)
        currentTime += jobtime
        while jobidx < len(jobs):
            if jobs[jobidx][0] <= currentTime:
                heapq.heappush(heap, [jobs[jobidx][1], jobs[jobidx][0]])
                jobidx += 1
            else:
                break

        answer += (currentTime - arrive)
        
        if not heap and jobidx < len(jobs):
            currentTime = jobs[jobidx][0]
            heapq.heappush(heap, [jobs[jobidx][1], jobs[jobidx][0]])
            jobidx += 1

    
    answer = answer // len(jobs)
    return answer
